package ru.yaltrip.model;

/**
 * This enum class represent entity {@link Role} witch it contains user roles on the site,
 * for example, the moderator role, the role of a regular user, and so on. This entity dependent of {@link User}.
 */
public enum Role {
    ROLE_USER,
    ROLE_ADMIN
}
