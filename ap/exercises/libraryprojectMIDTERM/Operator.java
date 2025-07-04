package ap.exercises.libraryprojectMIDTERM;


public class Operator extends Person implements TabSplitAble {
    private final int EMPLOYEE_ID;
    private String educationalLevel;

    public Operator(int previousOperators, String firstName, String lastName) {
        super(firstName, lastName);
        EMPLOYEE_ID = 403999001 + previousOperators;
    }

    public Operator(int employeeId, String firstName, String lastName,int consVersionAlways2) {
        super(firstName, lastName);
        this.EMPLOYEE_ID = employeeId;
    }

    public int getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }


    @Override
    public String toTabSplit() {
        return EMPLOYEE_ID + "\t" + super.toTabSplit();
    }

    public int getEmployeeId() {
        return EMPLOYEE_ID;
    }

    public void setInfo(String[] infos) {
        this.setFirstName(infos[0]);
        this.setLastName(infos[1]);
        this.educationalLevel = infos[2];
        System.out.println("Information Successfully Changed.");
    }

    public boolean isIdSimilar(int id) {
        return this.EMPLOYEE_ID == id;
    }

    public boolean equals(Object b) {
        if (this == b) {
            return true;
        }
        if (b == null || b.getClass() != this.getClass()) {
            return false;
        }
        Operator operator = (Operator) b;
        return (this.EMPLOYEE_ID == operator.EMPLOYEE_ID);
    }

}
