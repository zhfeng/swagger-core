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

package io.swagger.v3.core.oas.models.composition;

import io.swagger.v3.oas.annotations.media.Schema;

public interface Pet extends Animal {
    @Schema(required = true, description = "The pet type")
    String getType();

    void setType(String type);

    @Schema(required = true, description = "The name of the pet")
    String getName();

    void setName(String name);

    @Schema(required = true)
    Boolean getIsDomestic();

    void setIsDomestic(Boolean isDomestic);
}
