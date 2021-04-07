package org.solvd.healthSystem.enums;

public enum Permissions {
    CREATE_PARTNER("permission for create partner", true),
    DELETE_PARTNER("permission for delete partner", true),
    MODIFY_PARTNER("permission for modify partner", true),
    GET_PARTNER("permission for get partner", true);


    private String permission;
    private boolean hasPermissions;

    private Permissions(String permission, boolean hasPermissions) {
        this.permission = permission;
        this.hasPermissions = hasPermissions;
    }
}
