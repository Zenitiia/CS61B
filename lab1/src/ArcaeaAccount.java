import java.util.Objects;

public class ArcaeaAccount {

    private double ptt_value;
    private String account_name;
    private String current_partner;
    private String[] available_partners = new String[2];

    public ArcaeaAccount(String name) {
        this.account_name = name;
        available_partners[0] = "Hikari";
        available_partners[1] = "Tairitsu";
    }

    public String get_account_name() {
        return this.account_name;
    }

    public void set_ptt(double ptt) {
        this.ptt_value = ptt;
    }

    public double get_ptt_value() {
        return this.ptt_value;
    }

    public void set_current_partner(String partner_name) {
        this.current_partner = partner_name;
    }

    public String get_current_partner() {
        return this.current_partner;
    }

    public String[] get_available_partners() {
        return this.available_partners;
    }

    public void say_sth() {
        if (Objects.equals(this.current_partner, "Hikari")) {
            System.out.println("我天天对着对立打交");
        } else {
            System.out.println("我要杀光光");
        }
    }

    public static void main(String[] args) {
        ArcaeaAccount account = new ArcaeaAccount("Macro233");
        account.set_ptt(11.55);

        System.out.println("Account name: " + account.get_account_name());
        System.out.println("Current PTT: " + account.get_ptt_value());

        account.set_current_partner("Hikari");
        System.out.println("Current partner: " + account.get_current_partner());

        System.out.println("Available partners: ");
        for (String name : account.get_available_partners()) {
            System.out.println(name);
        }

        System.out.print(account.get_current_partner() + ": ");
        account.say_sth();
    }
}
