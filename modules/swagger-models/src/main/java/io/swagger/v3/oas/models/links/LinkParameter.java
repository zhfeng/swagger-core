/**
 * Copyright 2017 SmartBear Software
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

package io.swagger.v3.oas.models.links;

import io.swagger.v3.oas.annotations.OpenAPI31;

import java.util.Objects;

/**
 * LinkParameter
 *
 * @see "https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md#linkOParametersbject"
 */

public class LinkParameter {
    private String value;

    public LinkParameter() {
    }

    private java.util.Map<String, Object> extensions = null;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LinkParameter value(String value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkParameter linkParameters = (LinkParameter) o;
        return Objects.equals(this.value, linkParameters.value) &&
                Objects.equals(this.extensions, linkParameters.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, extensions);
    }

    public java.util.Map<String, Object> getExtensions() {
        return extensions;
    }

    public void addExtension(String name, Object value) {
        if (name == null || name.isEmpty() || !name.startsWith("x-")) {
            return;
        }
        if (this.extensions == null) {
            this.extensions = new java.util.LinkedHashMap<>();
        }
        this.extensions.put(name, value);
    }

    @OpenAPI31
    public void addExtension31(String name, Object value) {
        if (name != null && (name.startsWith("x-oas-") || name.startsWith("x-oai-"))) {
            return;
        }
        addExtension(name, value);
    }

    public void setExtensions(java.util.Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    public LinkParameter extensions(java.util.Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LinkParameter {\n");

        sb.append("}");
        return sb.toString();
    }

}

