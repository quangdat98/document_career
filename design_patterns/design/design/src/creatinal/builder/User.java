package creatinal.builder;

public class User {
    private String id;
    private String name;
    private String password;

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.password = builder.password;
    }

    public static class Builder {
        private String id;
        private String name;
        private String password;

        public Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        //set value for class user from builder
        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "user: " + id + ", " + name + ", " + password;
    }
}
