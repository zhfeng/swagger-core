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

package io.swagger.v3.jaxrs2.petstore.parameter;

import io.swagger.v3.jaxrs2.resources.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Class with a multiple annotated.
 */
public class ComplexParameterWithOperationResource {

    @Parameter(description = "Phone definied in Field")
    private String phone;

    public ComplexParameterWithOperationResource(@Parameter(description = "phone Param", name = "phone") final String phone) {
        this.phone = phone;
    }

    @GET
    @Path("/complexparameter")
    @Operation(operationId = "create User",
            parameters = {
                    @Parameter(description = "Phone", name = "phone", in = ParameterIn.PATH)
            })
    public User findUser(@Parameter(description = "idParam") @QueryParam("id") final String id,
                         final String name, @QueryParam("lastName") final String lastName,
                         @Parameter(description = "address", schema = @Schema(implementation = User.class))
                         @QueryParam("address") final String address) {
        return new User();
    }
}
