public class Main {
    public static void main(String[] args) {
        JumpableRunnable[] members = {
                new Human(3, 1000, "Navalniy"),
                new Human(1, 100, "Putin"),
                new Cat(3, 100, "Pushistik"),
                new Cat(1, 50, "Murka"),
                new Robot(0, 1000, 1),
                new Robot(4,700,2)
        };

        Obstaclable[] obstacles = {
                new RunningTrack(100),
                new RunningTrack(500),
                new Wall(1),
                new Wall(3)
        };

        for (JumpableRunnable member : members) {
            System.out.println("На арену выходит " + member);
            boolean winner = true;
            for (Obstaclable obstacle : obstacles) {
                System.out.println(member + " начинает проходить задание " + obstacle);
                if (obstacle.toJump(member.getMaxHeight()) ||
                        obstacle.toRun(member.getMaxLength())) {
                    System.out.println("И он сделал это!");
                } else {
                    winner = false;
                    System.out.println("Это эпик фейл он не смог.");
                    break;
                }
            }

            if(winner) {
                System.out.println(member + " прошёл дистанцию!");
            } else {
                System.out.println(member + " с позором покидает арену.");
            }
            System.out.println();
        }
    }
}
