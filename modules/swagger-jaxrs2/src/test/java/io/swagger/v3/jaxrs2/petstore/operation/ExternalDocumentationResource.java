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

package io.swagger.v3.jaxrs2.petstore.operation;

import io.swagger.v3.jaxrs2.resources.exception.NotFoundException;
import io.swagger.v3.jaxrs2.resources.model.Pet;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Resource with Operations Examples
 */
public class ExternalDocumentationResource {
    @GET
    @Path("/{petId}")
    @Operation(summary = "Find pet by ID",
            description = "Returns a pet when 0 < ID <= 10.  ID > 10 or non integers will simulate API error conditions",
            operationId = "petId",
            externalDocs = @ExternalDocumentation(description = "External in Operation", url = "http://url.me"))
    @ExternalDocumentation(description = "External Annotation Documentation", url = "http://url.me")
    public Response getPetById(
            @Parameter(description = "ID of pet that needs to be fetched", required = true)
            @PathParam("petId") Long petId) throws NotFoundException {
        return Response.ok().entity(new Pet()).build();
    }
}
