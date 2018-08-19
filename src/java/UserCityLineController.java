
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import model.City;
import model.CityLine;
import model.RegisteredUser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */
public class UserCityLineController {
    
    private RegisteredUser user;
    private CityLineService cityLineService;

    public UserCityLineController(RegisteredUser user, City city) {
        this.user = user;
        this.cityLineService = new CityLineService();
        CityLine exampleCityLine = new CityLine();
        exampleCityLine.setCity(city);
        this.cityLineService.setExampleCityLine(exampleCityLine);
        this.cityLineService.setByExample();
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public CityLineService getCityLineService() {
        return cityLineService;
    }

    public void setCityLineService(CityLineService cityLineService) {
        this.cityLineService = cityLineService;
    }
    
}
