public class patient {
    private String Firstname;
    private String Lastname;
    private String DateOfBirth;
    private String Gender;
    private String phone;
    private String address;
    private String email;
    private String EmergencyContact;
    //conditions
    private String PastMedicalCondition;
    private String SurgicalHistory;
    private String Allergies;
    private String CurrentMedications;
    private String FamilyMedicalHistory;
    //private String VitalSigns;
    private float BloodPressure;
    private float Temperature;
    private float HeartRate;
    private int RespiratoryRate;
    private float height;
    private float weight;
    private float BMI;
    private String PhysicalExamination;
    //private String DiagnosticTestResults;
    private String LabTest;
    private String MRI;
    private String X_RAY;
    //Treatment
    private String PrescribedMedication;
    private String Dosage;
    private String frequency_and_instructions;
    private String OrderedDiagnosticTests;
    private String ReferralsToSpecialists;
    private String ImmunizationRecords;
    //appointments
    private String Schedule;
    //billings
    private String InsuranceInfo;
    private String PaymentHistory;

    patient(String Firstname, String Lastname, String DateOfBirth, String Gender, String phone, String address, String email, String EmergencyContact){
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.DateOfBirth = DateOfBirth;
        this.Gender = Gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.EmergencyContact = EmergencyContact;
    }

    public void GetCondition(String PastMedicalCondition, String SurgicalHistory, String Allergies, String CurrentMedications, String FamilyMedicalHistory){
        this.PastMedicalCondition = PastMedicalCondition;
        this.SurgicalHistory = SurgicalHistory;
        this.Allergies = Allergies;
        this.CurrentMedications = CurrentMedications;
        this.FamilyMedicalHistory = FamilyMedicalHistory;
    }

    public void GetVitalSigns(float BloodPressure, float Temperature, float HeartRate, int RespiratoryRate, float height, float weight, String PhysicalExamination){
        this.BloodPressure = BloodPressure;
        this.Temperature = Temperature;
        this.HeartRate = HeartRate;
        this.RespiratoryRate = RespiratoryRate;
        this.height = height;
        this.weight = weight;
        this.PhysicalExamination = PhysicalExamination;
    }

    public void GetDiagnostics(String LabTest, String MRI, String X_RAY){
        this.LabTest = LabTest;
        this.MRI = MRI;
        this.X_RAY = X_RAY;
    }

    public void GetTreatments(String PrescribedMedication, String Dosage, String frequency_and_instructions, String OrderedDiagnosticTests, String ReferralsToSpecialists, String ImmunizationRecords){
        this.PrescribedMedication = PrescribedMedication;
        this.Dosage = Dosage;
        this.frequency_and_instructions = frequency_and_instructions;
        this.OrderedDiagnosticTests = OrderedDiagnosticTests;
        this.ReferralsToSpecialists = ReferralsToSpecialists;
        this.ImmunizationRecords = ImmunizationRecords;
    }

    public void GetBillings(String Schedule, String InsuranceInfo, String PaymentHistory){
        this.Schedule = Schedule;
        this.InsuranceInfo = InsuranceInfo;
        this.PaymentHistory = PaymentHistory;
    }

    public void PrintInfo(){
        System.out.println();
        System.out.println("**********PATIENT INFO**********");
        System.out.println("First name: " + this.Firstname);
        System.out.println("Last name: " + this.Lastname);
        System.out.println("Date of Birth: " + this.DateOfBirth);
        System.out.println("Gender: " + this.Gender);
        System.out.println("Phone number: " + this.phone);
        System.out.println("Address: " + this.address);
        System.out.println("Email: " + this.email);
        System.out.println("Emergency Contact: " + this.EmergencyContact);
        System.out.println("Past Medical Condition: " + this.PastMedicalCondition);
        System.out.println("Surgical History: " + this.SurgicalHistory);
        System.out.println("Allergies: " + this.Allergies);
        System.out.println("Current medications: " + this.CurrentMedications);
        System.out.println("Family Medical History: " + this.FamilyMedicalHistory);
        System.out.println("Blood Pressure: " + this.BloodPressure);
        System.out.println("Temperature: " + this.Temperature);
        System.out.println("Heart Rate: " + this.HeartRate);
        System.out.println("Respiratory Rate: " + this.RespiratoryRate);
        System.out.println("Height: " + this.height);
        System.out.println("Weight: " + this.weight);
        System.out.println("BMI: " + this.calcBMI(height, weight));
        System.out.println("Physical Examination: " + this.PhysicalExamination);
        System.out.println("Lab tests: " + this.LabTest);
        System.out.println("MRI: " + this.MRI);
        System.out.println("X-Ray: " + X_RAY);
        System.out.println("Dosage: " + this.Dosage);
        System.out.println("Frequency and Instructions: " + this.frequency_and_instructions);
        System.out.println("Ordered diagnostic tests: " + this.OrderedDiagnosticTests);
        System.out.println("Referrals to specialists: " + this.ReferralsToSpecialists);
        System.out.println("Immunization records: " + this.ImmunizationRecords);
        System.out.println("Schedules: " + this.Schedule);
        System.out.println("Insurance information: " + this.InsuranceInfo);
        System.out.println("Payment history: " + this.PaymentHistory);
        System.out.println();
    }

    public float calcBMI(float height, float weight){
        float result = (weight)/(height*height);
        return result;
    }
}
