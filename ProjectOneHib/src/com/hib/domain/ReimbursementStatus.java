package com.hib.domain;

import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "REIMBURSEMENT_STATUS")
public class ReimbursementStatus implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7366994008947505138L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statusSequence")
    @SequenceGenerator(allocationSize = 1, name = "statusSequence", sequenceName = "REIMBURSEMENT_STATUS_SEQ")
    @Column(name = "RS_ID")
    private int id;

    @Column(name = "RS_STATUS")
    private String status;

    public ReimbursementStatus(String status) {
        super();
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReimbursementStatus [id=" + id + ", status=" + status + "]";
    }

}
