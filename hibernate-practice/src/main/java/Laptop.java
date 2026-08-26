import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    @Column(name = "l_id")
    private int l_id;

    @Column(name = "ram")
    private int ram;

    @Column(name = "brand")
    private String brand;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "l_id=" + l_id +
                ", ram=" + ram +
                ", brand='" + brand + '\'' +
                '}';
    }
}