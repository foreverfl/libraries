package graphql._02_Schema;

public class SchemaScalars {
    private String id;
    private boolean isTrue;
    private int num1;
    private float num2;
    private String str;

    public SchemaScalars(String id, boolean isTrue, int num1, float num2, String str) {
        this.id = id;
        this.isTrue = isTrue;
        this.num1 = num1;
        this.num2 = num2;
        this.str = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIsTrue() {
        return this.isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    public int getNum1() {
        return this.num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return this.num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public String getStr() {
        return this.str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}
