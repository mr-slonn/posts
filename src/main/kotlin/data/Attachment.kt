package data

// Объект, описывающий вложение
interface Attachment {
    val type: String
}

// Объект, описывающий вложение аудиозапись
class AudioAttachment(param: Audio) : Attachment {
    override val type: String = "audio"
    val audio = param
}

// Вложение фотография
class PhotoAttachment(param: Photo) : Attachment {
    override val type: String = "photo"
    val photo = param
}

// Вложение заметка
class NoteAttachment(param: Note) : Attachment {
    override val type: String = "note"
    val note = param
}

// Вложение видеозапись
class VideoAttachment(param: Video) : Attachment {
    override val type: String = "video"
    val video = param
}


// Объект, описывающий фотографию
data class Photo(
    // Идентификатор фотографии.
    val id: Long,
    // Идентификатор альбома, в котором находится фотография.
    val albumId: Long,
    // Идентификатор владельца фотографии.
    val ownerId: Long,
    // Идентификатор пользователя, загрузившего фото (если фотография размещена в сообществе).
    // Для фотографий, размещенных от имени сообщества, user_id = 100.
    val userId: Long,
    // Текст описания фотографии.
    val text: String,
    // Дата добавления в формате Unixtime.
    val date: Long = System.currentTimeMillis(),
    // Массив с копиями изображения в разных размерах.
    // val sizes : Array<Sizes> = emptyArray(), // скрыл так как пока не понимаю рекомендацию IDE
    // Ширина оригинала фотографии в пикселах.
    val width: Int,
    // Высота оригинала фотографии в пикселах.
    val height: Int
)

data class Sizes(
    // Обозначение размера и пропорций копии.
    val type: String,
    //URL копии изображения.
    val url: String,
    // Ширина копии в пикселах.
    val width: Int,
    // Высота копии в пикселах.
    val height: Int
)

// Объект, описывающий аудиозапись
data class Audio(
    // Идентификатор аудиозаписи.
    val id: Long,
    // Идентификатор владельца аудиозаписи.
    val ownerId: Long,
    // Исполнитель
    val artist: String,
    // Название композиции
    val title: String,
    // Длительность аудиозаписи в секундах
    val duration: Int,
    // Ссылка на mp3.
    val url: String,
    // Идентификатор текста аудиозаписи (если доступно).
    val lyricsId: Long,
    // Идентификатор альбома, в котором находится аудиозапись (если присвоен).
    val albumId: Long,
    // Идентификатор жанра из списка аудио жанров.
    val genreId: Long,
    // Дата добавления.
    val date: Long = System.currentTimeMillis(),
    val noSearch: Int, // 1, если включена опция «Не выводить при поиске». Если опция отключена, поле не возвращается.
    val isHq: Int, // 1, если аудио в высоком качестве.
)

data class Video(
    //	Идентификатор видеозаписи
    val id: Long,
    // Идентификатор владельца видеозаписи
    val ownerId: Int,
    // Название видеозаписи
    val title: String,
    // Текст описания видеозаписи
    val description: String,
    // Длительность ролика в секундах
    val duration: Int,
    // Изображение обложки
    //val image : Array<Image> = emptyArray(),  // скрыл так как пока не понимаю рекомендацию IDE
    // Изображение первого кадра
    // val firstFrame : Array<Image> = emptyArray(),  // скрыл так как пока не понимаю рекомендацию IDE
    // Дата создания видеозаписи в формате Unixtime
    val date: Long = System.currentTimeMillis(),
    // Дата добавления видеозаписи пользователем или группой в формате Unixtime.
    val addingDate: Long,
    //	Количество просмотров видеозаписи
    val views: Int,
    // Если видео внешнее, количество просмотров в ВК
    val localViews: Int,
    // Количество комментариев к видеозаписи
    val comments: Int,
    // URL страницы с плеером, который можно использовать для воспроизведения ролика в браузере.
    // Поддерживается flash и html5, плеер всегда масштабируется по размеру окна.
    val player: String,
    // Название платформы (для видеозаписей, добавленных с внешних сайтов)
    val platform: String,
    // Может ли пользователь добавить видеозапись к себе, true может
    val canAdd: Boolean,
    // Поле возвращается, если видеозапись приватная (например, была загружена в личное сообщение), всегда содержит 1.
    val isPrivate: Boolean = true,
    // Ключ доступа к объекту. Подробнее см. Ключ доступа к данным access_key.
    val accessKey: String,
    // Поле возвращается в том случае, если видеоролик находится в процессе обработки, всегда содержит 1.
    val processing: Boolean,
    // true, если объект добавлен в закладки у текущего пользователя.
    val isFavorite: Boolean,
    // Может ли пользователь комментировать видео, True может
    val canComment: Boolean,
    // Может ли пользователь редактировать видео, true может
    val canEdit: Boolean,
    // Может ли пользователь добавить видео в список <<Мне нравится>>, true может
    val canLike: Boolean,
    // Может ли пользователь сделать репост видео, true может
    val canRepost: Boolean,
    // Может ли пользователь подписаться на автора видео, true может
    val canSubscribe: Boolean,
    // Может ли пользователь добавить видео в избранное, true может
    val canAddToFaves: Boolean,
    // Может ли пользователь прикрепить кнопку действия к видео, true может
    val canAttachLink: Boolean,
    // Ширина видео
    val width: Int,
    // Высота видео
    val height: Int,
    // Идентификатор пользователя, загрузившего видео, если оно было загружено в группу одним из участников
    val userId: Long,
    // Конвертируется ли видео, true - да
    val converting: Boolean,
    // Добавлено ли видео в альбомы пользователя, true - да
    val added: Boolean,
    // Подписан ли пользователь на автора видео.true - да
    val isSubscribed: Boolean,
    // Поле возвращается в том случае, если видео зациклено, всегда содержит 1
    val repeat: Int = 1,
    // Тип видеозаписи. Может принимать значения: "video", "music_video", "movie".
    val type: String,
    // Баланс донатов в прямой трансляции.
    val balance: Int,
    // Статус прямой трансляции. Может принимать значения: "waiting", "started", "finished", "failed", "upcoming".
    val liveStatus: String,
    // Поле возвращается в том случае, если видеозапись является прямой трансляцией, всегда содержит 1.
    // Обратите внимание, в этом случае в поле duration содержится значение 0.
    val live: Boolean,
    // Поле свидетельствует о том, что трансляция скоро начнётся
    val upcoming: Boolean,
    // Количество зрителей прямой трансляции
    val spectators: Int,
    // Содержит объект отметки <<Мне нравится>>
    val likes: VideoLikes,
    // Содержит объект репоста.
    val reposts: VideoReposts
)

// Объект, описывающий изображение обложки
data class Image(
    //Высота изображения.
    val height: Int,
    // Ссылка на изображение
    val url: String,
    // Ширина изображения
    val width: Int,
    // Поле возвращается, если изображение с отбивкой, всегда содержит 1.
    val withPadding: Int = 1
)

// Объект описывающий отметки «Мне нравится».
data class VideoLikes(
    // Количество лайков
    val count: Int,
    // Добавлено ли видео в список, true добавлено
    val userLikes: Boolean
)

// Объект описывающий репост видео.
data class VideoReposts(
    //  Счетчик общего количества репостов. Содержит сумму репостов на стену и в личные сообщения
    val count: Int,
    // Счетчик репостов на стену
    val wallCount: Int,
    // Счетчик репостов в личные сообщения
    val mailCount: Int,
    // Информация о том, сделал ли текущий пользователь репост этого видео.
    val userReposted: Boolean
)

// Объект, описывающий заметку
data class Note(
    // Идентификатор заметки.
    val id: Long,
    // Идентификатор владельца заметки.
    val ownerId: Long,
    // Заголовок заметки.
    val title: String,
    // Текст заметки.
    val text: String,
    // Дата создания заметки в формате Unixtime.
    val date: Long = System.currentTimeMillis(),
    // Количество комментариев.
    val comments: Int,
    // Количество прочитанных комментариев (только при запросе информации о заметке текущего пользователя).
    val readComments: Int,
    // URL страницы для отображения заметки.
    val viewUrl: String,
    // Настройки приватности просмотра заметки
    val privacyView: String,
    // Настройки приватности комментирования заметки
    val privacyComment: String,
    // Есть ли возможность оставлять комментарии
    val canComment: Boolean,
    // Тэги ссылок на wiki
    val textWiki: String
)