package vunt.com.vn.sqlitecontentprovider;

public class MyContact {
    private String mName;
    private String mPhone;

    public MyContact(String name, String phone) {
        mName = name;
        mPhone = phone;
    }

    public String getName() {
        return mName;
    }

    public MyContact setName(String name) {
        mName = name;
        return this;
    }

    public String getPhone() {
        return mPhone;
    }

    public MyContact setPhone(String phone) {
        mPhone = phone;
        return this;
    }
}
