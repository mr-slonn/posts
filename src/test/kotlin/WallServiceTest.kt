import data.Comment
import data.Post
import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import service.WallService

class WallServiceTest {

    @Test
    fun updateExisting() {

        val  service = WallService()

        service.add(
            Post(
                fromId = 1,
                text = "Привет я пост 1",
            )
        )
        service.add(
            Post(
                fromId = 2,

                text = "Привет я пост 2",
            )
        )
        service.add(
            Post(
                fromId = 1,
                text = "Привет я пост 3",

                )
        )
        val update = Post(
            id = 1,
            fromId = 1,
            text = "Привет я пост изменны",
        )
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun removeById() {
        val  service = WallService()

        service.add(
            Post(
                fromId = 1,
                text = "Привет я пост 1",
            )
        )
        service.add(
            Post(
                fromId = 2,

                text = "Привет я пост 2",
            )
        )
        service.add(
            Post(
                fromId = 1,
                text = "Привет я пост 3",

                )
        )

        val result = service.removeById(1)
        assertTrue(result)
    }

    @Test
    fun removeByIdFalse() {
        val  service = WallService()

        service.add(
            Post(
                fromId = 1,
                text = "Привет я пост 1",
            )
        )
        service.add(
            Post(
                fromId = 2,

                text = "Привет я пост 2",
            )
        )
        service.add(
            Post(
                fromId = 1,
                text = "Привет я пост 3",

                )
        )
        val result = service.removeById(4)
        assertFalse(result)
    }

    @Test
    fun likeById() {
        val  service = WallService()
        service.add(
            Post(
                fromId = 1,
                text = "Привет я пост 1",
            )
        )
        service.add(
            Post(
                fromId = 2,
                text = "Привет я пост 2",
            )
        )
        service.add(
            Post(
                fromId = 1,
                text = "Привет я пост 3",
                )
        )
         service.likeById(1)
        val result = service.getLikeById (1)
        Assert.assertEquals(1, result)
    }

    @Test
    fun createComment() {
        val  service = WallService()
        service.add(
            Post(
                fromId = 1,
                text = "Привет я пост 1",
            )
        )
        service.add(
            Post(
                fromId = 2,
                text = "Привет я пост 2",
            )
        )
        service.add(
            Post(
                fromId = 1,
                text = "Привет я пост 3",
            )
        )

        val result = service.createComment(1, Comment(
            text = "Привет я коммент к посту  1",
        )
        )

        Assert.assertEquals(Comment(id=1,text = "Привет я коммент к посту  2"  ), result)
    }
}