import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import methods.Method;
import model.Pet;
import model.PetsCategory;
import model.PetsStatus;
import model.Tags;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cases extends Method {
    private static final PetsCategory PETS_CATEGORY = new PetsCategory("10","Kopek");
    private static final Tags TAGS = new Tags("18","string");
    private static final PetsStatus PETS_STATUS = new PetsStatus("available");
    private static final Pet pet = new Pet("17",PETS_CATEGORY, "Herkul", TAGS, PETS_STATUS);

    @Test(priority = 1)
    public void addPet () {
        Response response = postMethod(pet);
        JsonPath json = response.jsonPath();
        Assert.assertEquals(PETS_CATEGORY.getId(),json.getString("category.id"));
        Assert.assertNotEquals(PETS_CATEGORY.getId(),json.getString("id"));
    }
    @Test(priority = 2)
    public void getPetById () {
        Response response = getMethod(pet.getId());
        JsonPath json = response.jsonPath();
        Assert.assertEquals(pet.getId(),json.getString("id"));
    }
    @Test(priority = 3)
    public void updatePet (){
        String name = "Zeus";
        pet.setName(name);
        Response response = putMethod(pet);
        JsonPath json = response.jsonPath();
        Assert.assertEquals(name,json.getString("name"));
    }
    @Test(priority = 4)
    public void deletePetById(){
        String id = pet.getId();
        Response response = deleteMethod(id);
        JsonPath json = response.jsonPath();
        Assert.assertEquals(id,json.getString("message"));
    }
}
