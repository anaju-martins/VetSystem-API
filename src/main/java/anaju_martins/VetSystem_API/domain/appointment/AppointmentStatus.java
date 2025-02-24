package anaju_martins.VetSystem_API.domain.appointment;

public enum AppointmentStatus {

    SCHEDULED(1),
    COMPLETED(2),   // Corrigido aqui (removido o "9")
    CANCELLED(3);

    private int code;

    private AppointmentStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AppointmentStatus valueOf(int code) {
        for (AppointmentStatus status : AppointmentStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid AppointmentStatus code: " + code);
    }
}
