package ker.teerapat.survivalgear;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Survivalgear {
    private @Id
    @GeneratedValue Long id;
    private String survivalgearDetail;
    private String ownerName;
    private String locationName;
    private Boolean borrowed;
    private String borrowerName;

    Survivalgear() {}

    public Survivalgear(String survivalgearDetail, String ownerName, String locationName, Boolean borrowed, String borrowerName) {
        this.survivalgearDetail = survivalgearDetail;
        this.ownerName = ownerName;
        this.locationName = locationName;
        this.borrowed = borrowed;
        this.borrowerName = borrowerName;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSurvivalgearDetail() {
        return survivalgearDetail;
    }
    public void setSurvivalgearDetail(String survivalgearDetail) {
        this.survivalgearDetail = survivalgearDetail;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getLocationName() {
        return locationName;
    }
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    public Boolean getBorrowed() {
        return borrowed;
    }
    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }
    public String getBorrowerName() {
        return borrowerName;
    }
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((survivalgearDetail == null) ? 0 : survivalgearDetail.hashCode());
        result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
        result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
        result = prime * result + ((borrowed == null) ? 0 : borrowed.hashCode());
        result = prime * result + ((borrowerName == null) ? 0 : borrowerName.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Survivalgear other = (Survivalgear) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (survivalgearDetail == null) {
            if (other.survivalgearDetail != null)
                return false;
        } else if (!survivalgearDetail.equals(other.survivalgearDetail))
            return false;
        if (ownerName == null) {
            if (other.ownerName != null)
                return false;
        } else if (!ownerName.equals(other.ownerName))
            return false;
        if (locationName == null) {
            if (other.locationName != null)
                return false;
        } else if (!locationName.equals(other.locationName))
            return false;
        if (borrowed == null) {
            if (other.borrowed != null)
                return false;
        } else if (!borrowed.equals(other.borrowed))
            return false;
        if (borrowerName == null) {
            if (other.borrowerName != null)
                return false;
        } else if (!borrowerName.equals(other.borrowerName))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Storage [id=" + id + ", survivalgearDetail=" + survivalgearDetail + ", ownerName=" + ownerName + ", locationName="
                + locationName + ", borrowed=" + borrowed + ", borrowerName=" + borrowerName + "]";
    }
}