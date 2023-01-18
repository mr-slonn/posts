import data.Post
import service.WallService

class WallServiceTest {
    @Test
    fun updateExisting() {
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(Post(

        ))
        service.add(Post(/* заполняете поля */))
        service.add(Post(/* заполняете поля */))
        // создаём информацию об обновлении
        val update = Post(/* заполняете поля */)

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }
}