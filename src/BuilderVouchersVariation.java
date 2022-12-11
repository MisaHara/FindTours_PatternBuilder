import java.util.Scanner;

public class BuilderVouchersVariation {
    public static void main(String[] args) {
        String morning = String.valueOf(DataVouchers.MORNING);
        String evening = String.valueOf(DataVouchers.EVENING);
        String night = String.valueOf(DataVouchers.NIGHT);

        final String place = "Место: ";
        final String data = "Время: ";
        final String prise = "Цена: " ;

        System.out.println("Куда желаете отправится?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        switch (input) {
            case "Турция" -> {
                Vouchers Turk = new Vouchers.Builder("Turkey").setData(morning).setPrice(58000).build();
                System.out.println(place + Turk.getPlace());
                System.out.println(data + Turk.getTime());
                System.out.println(prise + Turk.getPrice());
            }
            case "Италия" -> {
                Vouchers Italy = new Vouchers.Builder("italy").setData(evening).setPrice(122000).build();
                System.out.println(place + Italy.getPlace());
                System.out.println(data + Italy.getTime());
                System.out.println(prise + Italy.getPrice());
            }
            case "Китай" -> {
                Vouchers China = new Vouchers.Builder("China").setData(night).setPrice(77000).build();
                System.out.println(place + China.getPlace());
                System.out.println(data + China.getTime());
                System.out.println(prise + China.getPrice());
            }
            default -> System.out.println("Данной путевки у нас нет или вы ввели некорректное значение");
        }
    }
}
    class Vouchers {
        private final String place;
        private final DataVouchers data;
        private final int price;

        public String getPlace() {
            return place;
        }

        public DataVouchers getTime() {
            return data;
        }

        public int getPrice() {
            return price;
        }
        private Vouchers(Builder builder) {
            this.place = builder.place;
            this.data = DataVouchers.valueOf(builder.data);
            this.price = builder.price;
        }
        static class Builder {
            private final String place;
            private String data;
            private int price;

            public Builder(String place) {
                this.place = place;
            }

            public Builder setData(String data) {
                this.data = data;
                return this;
            }

            public Builder setPrice(int price) {
                this.price = price;
                return this;
            }
            public Vouchers build() {
                return new Vouchers(this);
            }
        }
    }
