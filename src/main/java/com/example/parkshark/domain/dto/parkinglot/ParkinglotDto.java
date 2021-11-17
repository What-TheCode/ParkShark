package com.example.parkshark.domain.dto.parkinglot;

public class ParkinglotDto {
    private int id;
    private String name;
    private int capacity;
    private String email;
    private String tel;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public static class Builder {
        private int id;
        private String name;
        private int capacity;
        private String email;
        private String tel;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withTel(String tel) {
            this.tel = tel;
            return this;
        }

        public ParkinglotDto build() {
            ParkinglotDto parkinglotDto = new ParkinglotDto();
            parkinglotDto.id = this.id;
            parkinglotDto.name = this.name;
            parkinglotDto.capacity = this.capacity;
            parkinglotDto.email = this.email;
            parkinglotDto.tel = this.tel;
            return parkinglotDto;
        }
    }
}