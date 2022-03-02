/**
 * Copyright 2021 SmartBear Software
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.swagger.v3.jaxrs2.ext;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.swagger.v3.jaxrs2.ResolvedParameter;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.Operation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class AbstractOpenAPIExtension implements OpenAPIExtension {

    @Override
    public String extractOperationMethod(Method method, Iterator<OpenAPIExtension> chain) {
        if (chain.hasNext()) {
            return chain.next().extractOperationMethod(method, chain);
        } else {
            return null;
        }
    }

    @Override
    public ResolvedParameter extractParameters(List<Annotation> annotations, Type type, Set<Type> typesToSkip,
                                               Components components, javax.ws.rs.Consumes classConsumes,
                                               javax.ws.rs.Consumes methodConsumes, boolean includeRequestBody, JsonView jsonViewAnnotation, Iterator<OpenAPIExtension> chain) {
        if (chain.hasNext()) {
            return chain.next().extractParameters(annotations, type, typesToSkip, components, classConsumes, methodConsumes, includeRequestBody, jsonViewAnnotation, chain);
        } else {
            return new ResolvedParameter();
        }
    }

    @Override
    public void decorateOperation(Operation operation, Method method, Iterator<OpenAPIExtension> chain) {
        if (chain.hasNext()) {
            chain.next().decorateOperation(operation, method, chain);
        }
    }

    protected boolean shouldIgnoreClass(Class<?> cls) {
        return false;
    }

    protected boolean shouldIgnoreType(Type type, Set<Type> typesToSkip) {
        if (typesToSkip.contains(type)) {
            return true;
        }
        if (shouldIgnoreClass(constructType(type).getRawClass())) {
            typesToSkip.add(type);
            return true;
        }
        return false;
    }

    protected JavaType constructType(Type type) {
        return TypeFactory.defaultInstance().constructType(type);
    }
}
