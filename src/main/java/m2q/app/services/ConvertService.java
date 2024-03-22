package m2q.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    public String myService(String input){
        m2q.app.model.Model converter = new m2q.app.model.Model(input);
        converter.cleanUp();
        converter.createTables();
        converter.toSQL();
        String output = converter.getQueries();
        return output;
    }

}
