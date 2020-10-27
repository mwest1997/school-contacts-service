package edu.cnm.deepdive.schoolcontactsservice.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"studentId", "contactId"})
    }
)
public class StudentContact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false, updatable = false)
  private Long studentContactId;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "student_id", nullable = false, updatable = false)
  private Student student;


  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "contact_id", nullable = false, updatable = false)
  private Contact contact;

  private boolean primary;

  @NonNull
  @Column(nullable = false)
  private RelationshipType relationshipType;

  public Long getStudentContactId() {
    return studentContactId;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  @NonNull
  public RelationshipType getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(
      @NonNull RelationshipType relationshipType) {
    this.relationshipType = relationshipType;
  }

  public boolean isPrimary() {
    return primary;
  }

  public void setPrimary(boolean primary) {
    this.primary = primary;
  }

  private enum RelationshipType {PARENT, GUARDIAN, SIBLING, OTHER}

}
