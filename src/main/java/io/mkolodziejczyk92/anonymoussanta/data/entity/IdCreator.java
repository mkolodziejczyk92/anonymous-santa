package io.mkolodziejczyk92.anonymoussanta.data.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class IdCreator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IdCreator other) ) {
            return false;
        }
        if (getId() != null) {
            return getId().equals(other.getId());
        }
        return super.equals(other);
    }
}
