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

package io.swagger.v3.jaxrs2.resources;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static io.swagger.v3.oas.annotations.enums.Explode.FALSE;
import static io.swagger.v3.oas.annotations.enums.Explode.TRUE;

@Path("/things")
@Produces("application/json")
public class UrlEncodedResourceWithEncodings {

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response searchForThings( @BeanParam CompositeFormBody body ) {
        return Response.status(200).entity("Searching for something").build();
    }

    @POST
    @Path("/sriracha")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response srirachaThing(
            @Parameter(name = "id", style = ParameterStyle.FORM, explode = TRUE, description = "id param") @FormParam( "id" ) List<String> ids,
            @Parameter(name = "name", style = ParameterStyle.FORM, explode = FALSE) @FormParam( "name" ) List<String> names) {
        return Response.status(200).entity("Sriracha!").build();
    }

    public static class CompositeFormBody {
        @Parameter(name = "id", style = ParameterStyle.FORM, explode = TRUE, description = "id param")
        @FormParam("id")
        public List<String> ids;

        @Parameter(name = "name", style = ParameterStyle.FORM, explode = FALSE)
        @FormParam("name")
        public List<String> names;
    }
}
