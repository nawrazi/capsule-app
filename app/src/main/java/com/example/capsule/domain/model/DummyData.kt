package com.example.capsule.domain.model

object DummyData {
    private const val notes =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ac varius eros. Nullam in vehicula nisi. Vestibulum ac libero ac nulla dignissim vestibulum. Sed sodales luctus tincidunt. Aenean volutpat sapien id quam bibendum, ut iaculis arcu ullamcorper. Quisque tristique, leo sed tincidunt tincidunt, sem erat laoreet risus, nec fermentum arcu purus id nulla. Sed posuere, felis et eleifend tristique, arcu metus suscipit odio, nec malesuada eros elit sit amet massa. Vestibulum eget vulputate ex. Sed ac condimentum sem. Curabitur eget nulla id felis bibendum eleifend. Suspendisse ultricies, libero nec lacinia laoreet, quam nisl vehicula urna, a tempor sapien sapien eu elit. Donec semper, sem id congue dapibus, massa lorem tincidunt nunc, a finibus risus ipsum eu est. Integer id fermentum purus.\n" +
        "Nulla facilisi. Vestibulum auctor nisi et enim pellentesque tristique. Sed id justo venenatis, efficitur ex vel, feugiat sapien. Morbi a fermentum metus. Suspendisse nec lectus id odio bibendum dignissim. Praesent non dui id metus volutpat vulputate. Pellentesque eget metus ut massa eleifend fermentum. Integer tristique sagittis est, et malesuada tellus. Curabitur at varius purus. Integer congue, odio in dapibus facilisis, justo lorem convallis neque, in tristique mi ipsum nec urna. Vivamus efficitur, erat nec egestas rhoncus, elit urna ultrices justo, at consectetur purus purus in urna. Sed dictum cursus dapibus. Maecenas bibendum quam elit, et laoreet sem convallis vel. Sed a fermentum nulla, a dictum urna. Sed tempus, nunc sit amet varius efficitur, dolor ipsum volutpat justo, nec tincidunt eros quam eu metus. Integer facilisis ipsum sit amet bibendum. Donec non est eros.\n" +
        "Sed sed purus ut quam rhoncus bibendum. Vestibulum dictum dui sit amet ligula tempus, vel suscipit eros auctor. Fusce nec sapien sed sem lacinia tincidunt. Vestibulum malesuada justo et quam dignissim aliquam. Nulla bibendum, sapien et auctor accumsan, libero neque fermentum tortor, eget sollicitudin ante mi a dolor. Sed tristique mi sit amet est gravida vehicula. Sed sodales fringilla nunc, in pharetra massa bibendum sed. Donec in varius elit. Integer sed leo nec erat tincidunt cursus. Vivamus in dui nec odio euismod scelerisque. Suspendisse in ante elit. Vivamus ac turpis vel est tincidunt laoreet. Vestibulum in fermentum lectus. Nullam in tortor a mi tincidunt convallis ac id erat. Vivamus id nunc nec augue fringilla pharetra. Integer vel ultricies sapien. Nulla facilisi.\n" +
        "Sed posuere ante augue, id euismod tellus dignissim eu. Sed congue rhoncus est nec malesuada. Vivamus aliquet, risus non tincidunt cursus, nunc tortor varius est, eu vulputate augue arcu ut urna. Donec vel justo nec ligula tristique laoreet. Nullam tristique, orci ac feugiat blandit, ipsum elit lacinia ligula, vel vulputate ex est eu libero. Phasellus nec dictum tortor. Vestibulum viverra sapien ut lorem vehicula, ac cursus arcu rhoncus. Donec gravida, quam sit amet gravida varius, libero odio euismod ex, eu euismod orci sapien ut massa. Suspendisse potenti. Sed at augue a odio venenatis congue. Sed vestibulum turpis eu orci varius, eget bibendum dui vehicula. Maecenas accumsan ipsum sit amet mi laoreet, non egestas justo hendrerit.\n" +
        "Vivamus ullamcorper, tortor sit amet iaculis aliquam, nulla felis rhoncus lorem, nec tristique nisl nisl in libero. Donec blandit neque quis bibendum congue. Suspendisse dapibus elit eget erat lacinia, in ultricies tellus scelerisque. Integer vitae sollicitudin arcu. Suspendisse sed tristique eros, id facilisis tellus. Sed nec dolor sit amet tortor vehicula vulputate. Phasellus ut velit a elit gravida ultrices. Suspendisse potenti. Vivamus et tristique sapien, non pharetra justo. In tincidunt non dui eget interdum. Sed malesuada libero in bibendum condimentum. Maecenas cursus ut nunc ut gravida. Aenean nec neque ut nisl sodales tincidunt."

    val lesson = Lesson(
        id = "1",
        title = "Blood",
        notes = notes,
        videoUrl = "sample_video",
        quiz = Quiz(
            id = "2",
            questions = listOf(
                Question(
                    id = "1",
                    question = "What is the capital of the United States?",
                    options = listOf(
                        "Washington, D.C.",
                        "New York City",
                        "Los Angeles",
                        "Chicago"
                    ),
                    answerIndex = 1
                ),
                Question(
                    id = "2",
                    question = "What is the capital of Canada?",
                    options = listOf(
                        "Toronto",
                        "Ottawa",
                        "Montreal",
                        "Vancouver"
                    ),
                    answerIndex = 3
                ),
                Question(
                    id = "3",
                    question = "What is the capital of Mexico?",
                    options = listOf(
                        "Mexico City",
                        "Guadalajara",
                        "Monterrey",
                        "Tijuana"
                    ),
                    answerIndex = 0
                ),
            )
        ),
    )
}