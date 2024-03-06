class Solution {
    int maxHealth;
    public int solution(int[] bandage, int health, int[][] attacks) {
        maxHealth = health;
        for (int i = 0; i < attacks.length; i++) {
            if (i != 0) {
                int prev = attacks[i - 1][0];
                int now = attacks[i][0] - 1;
                int time = now - prev;
                int heal = time * bandage[1];
                heal += bandage[2] * (time / bandage[0]);
                health = Math.min(maxHealth, health + heal);
            }
            health -= attacks[i][1];
            if (health <= 0) {
                return -1;
            }
        }
        return health;
    }
}