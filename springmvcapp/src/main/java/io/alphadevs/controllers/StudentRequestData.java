package io.alphadevs.controllers;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

class StudentRequestData implements Serializable {
        @JsonProperty("name")
        private String name;
        @JsonProperty("age")
        private Integer age;

        public StudentRequestData() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

    }
