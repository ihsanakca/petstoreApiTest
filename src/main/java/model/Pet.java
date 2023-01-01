package model;

public class Pet {
    String id;
    PetsCategory petsCategory;
    String name;
    Tags tags;

    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": "+ getId() +",\n" +
                "  \"category\": {\n" +
                "    \"id\": "+getPetsCategory().getId()+",\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \""+getName()+"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": "+getTags().getId()+",\n" +
                "      \"name\": \""+getTags().getName()+"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \""+getPetsStatus().getStatus()+"\"\n" +
                "}";
    }

    public Pet(String id, PetsCategory petsCategory, String name, Tags tags, PetsStatus petsStatus) {
        this.id = id;
        this.petsCategory = petsCategory;
        this.name = name;
        this.tags = tags;
        this.petsStatus = petsStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PetsCategory getPetsCategory() {
        return petsCategory;
    }

    public void setPetsCategory(PetsCategory petsCategory) {
        this.petsCategory = petsCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public PetsStatus getPetsStatus() {
        return petsStatus;
    }

    public void setPetsStatus(PetsStatus petsStatus) {
        this.petsStatus = petsStatus;
    }

    PetsStatus petsStatus;
}
