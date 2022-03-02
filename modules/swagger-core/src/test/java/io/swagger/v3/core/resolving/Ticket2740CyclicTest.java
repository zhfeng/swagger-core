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

package io.swagger.v3.core.resolving;

import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverterContextImpl;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.core.matchers.SerializationMatchers;
import io.swagger.v3.core.resolving.resources.MyThing;
import io.swagger.v3.oas.models.media.Schema;
import org.testng.annotations.Test;

public class Ticket2740CyclicTest extends SwaggerTestBase {
    @Test
    public void testCyclicBean() throws Exception {
        final ModelResolver modelResolver = new ModelResolver(mapper());

        final ModelConverterContextImpl context = new ModelConverterContextImpl(modelResolver);

        final Schema model = context
                .resolve(new AnnotatedType(MyThing.class));

        SerializationMatchers.assertEqualsToYaml(model, "type: object\n" +
                "properties:\n" +
                "  otherThings:\n" +
                "    uniqueItems: true\n" +
                "    type: array\n" +
                "    description: Other related things\n" +
                "    items:\n" +
                "      $ref: '#/components/schemas/MyThing'\n" +
                "description: Thing");
    }

}
