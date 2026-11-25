class Student {

    private String registrationNumber;
    private String name;
    private int age;
    private double mark1;
    private double mark2;
    private double mark3;

    public Student(String registrationNumber, String name, int age,
                   double mark1, double mark2, double mark3) {

        this.registrationNumber = registrationNumber;
        this.name = name;
        this.age = age;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }

    public double getMark3() {
        return mark3;
    }

    public void setMark3(double mark3) {
        this.mark3 = mark3;
    }
    public double calculateAverage() {
        return (mark1 + mark2 + mark3) / 3;
    }
    public String getStatus() {
        if (calculateAverage() >= 50) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }
    public void displayInformation() {

        System.out.println("\n===== Student Information =====");

        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Mark 1: " + mark1);
        System.out.println("Mark 2: " + mark2);
        System.out.println("Mark 3: " + mark3);

        System.out.printf("Average: %.2f%n", calculateAverage());

        System.out.println("Status: " + getStatus());
    }
}