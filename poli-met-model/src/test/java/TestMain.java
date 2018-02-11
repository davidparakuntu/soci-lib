import com.dav.soci.model.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;


import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.concurrent.Executors;

public class TestMain {


    public static void main(String[] args) throws Exception{
        User user = new User();
        user.setId("User001");

        Name name = new Name();
        name.setFirstName("David");
        name.setLastName("Mathias");
        name.setFullName("David Mathias");
        name.setDisplayName("Raja Raja David Mathias");

        user.setName(name);

        Post post = new Post();
        post.setContent("This is a Test content");
        post.setHasImage(false);
        post.setPostedTime(new Date());

        Response response = new Response();
        response.setUserID("User001");
        response.setComment("Good one");
        response.setResponseType(ResponseType.NEGATIVE);



        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        writer.writeValue(new FileWriter(new File(user.getId()+".txt")),user);

    }
}
