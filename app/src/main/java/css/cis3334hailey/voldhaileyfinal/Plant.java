package css.cis3334hailey.voldhaileyfinal;

/**
 * Created by hvold on 5/7/2017.
 */

import java.io.Serializable;


public class Plant implements Serializable {
        private String key;
        private String name;


        public Plant(String key, String name) {
            this.key = key;
            this.name = name;
        }

        public Plant(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Plant{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}

