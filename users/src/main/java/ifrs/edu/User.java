package ifrs.edu;

import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.security.PermitAll;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

@Path("/getjwt")
public class User {
    
    @POST
    @Path("/jwt")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)

    //Código de autenticação
    
    public String generate(@FormParam("name") String name, @FormParam("email") String email) {
        return Jwt.issuer("http://localhost:8443")
            .upn("rodrigo@rpmhub.dev")
            .groups(new HashSet<>(Arrays.asList("User", "Admin")))
            .claim(Claims.full_name, "Rodrigo Prestes Machado")
            .claim(Claims.email, email)
            .sign();
}

}
