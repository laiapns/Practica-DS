package baseNoStates;

public class AccessPermission {
  private String validFrom;
  private String validTo;
  private String daysOfWeek;
  private String hoursOfDay;
  private String actions;
  private String accessibleSpaces;

  public AccessPermission(String validFrom, String validTo, String daysOfWeek, String hoursOfDay, String actions, String accessibleSpaces) {
    this.validFrom = validFrom;
    this.validTo = validTo;
    this.daysOfWeek = daysOfWeek;
    this.hoursOfDay = hoursOfDay;
    this.actions = actions;
    this.accessibleSpaces = accessibleSpaces;
  }

  // Getters and setters
  public String getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(String validFrom) {
    this.validFrom = validFrom;
  }

  public String getValidTo() {
    return validTo;
  }

  public void setValidTo(String validTo) {
    this.validTo = validTo;
  }

  public String getDaysOfWeek() {
    return daysOfWeek;
  }

  public void setDaysOfWeek(String daysOfWeek) {
    this.daysOfWeek = daysOfWeek;
  }

  public String getHoursOfDay() {
    return hoursOfDay;
  }

  public void setHoursOfDay(String hoursOfDay) {
    this.hoursOfDay = hoursOfDay;
  }

  public String getActions() {
    return actions;
  }

  public void setActions(String actions) {
    this.actions = actions;
  }

  public String getAccessibleSpaces() {
    return accessibleSpaces;
  }

  public void setAccessibleSpaces(String accessibleSpaces) {
    this.accessibleSpaces = accessibleSpaces;
  }

  @Override
  public String toString() {
    return "AccessPermissions{" +
        "validFrom='" + validFrom + '\'' +
        ", validTo='" + validTo + '\'' +
        ", daysOfWeek='" + daysOfWeek + '\'' +
        ", hoursOfDay='" + hoursOfDay + '\'' +
        ", actions='" + actions + '\'' +
        ", accessibleSpaces='" + accessibleSpaces + '\'' +
        '}';
  }
}