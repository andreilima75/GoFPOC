static class Pizza {
    private String size, crust, topping;

    private Pizza() {
    }

    static class Builder {
        private String size = "medium";
        private String crust = "thin";
        private String topping = "cheese";

        Builder size(String s) {
            this.size = s;
            return this;
        }

        Builder crust(String c) {
            this.crust = c;
            return this;
        }

        Builder topping(String t) {
            this.topping = t;
            return this;
        }

        Pizza build() {
            Pizza p = new Pizza();
            p.size = size;
            p.crust = crust;
            p.topping = topping;
            return p;
        }
    }

    public String toString() {
        return size + " pizza, " + crust + " crust, " + topping;
    }
}

void main() {
    Pizza p = new Pizza.Builder()
            .size("large").crust("thick").topping("pepperoni")
            .build();
    System.out.println(p);
}