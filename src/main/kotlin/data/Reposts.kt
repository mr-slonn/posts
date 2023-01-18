package data

data class Reposts(
    // число пользователей, скопировавших запись;
    val count: Int = 0,
    // наличие репоста от текущего пользователя (1 — есть, 0 — нет).
    val userReposted: Boolean = false,
)
