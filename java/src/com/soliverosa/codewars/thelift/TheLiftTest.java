package com.soliverosa.codewars.thelift;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TheLiftTest {

    @Test
    public void testDown() {
        final int[][] queues = {
                new int[0], // G
                new int[0], // 1
                new int[]{1,1}, // 2
                new int[0], // 3
                new int[0], // 4
                new int[0], // 5
                new int[0], // 6
        };
        final int[] result = Dinglemouse.theLift(queues,5);
        assertArrayEquals(new int[]{0,2,1,0}, result);
    }

    @Test
    public void testUp() {
        final int[][] queues = {
                new int[0], // G
                new int[0], // 1
                new int[]{5,5,5}, // 2
                new int[0], // 3
                new int[0], // 4
                new int[0], // 5
                new int[0], // 6
        };
        final int[] result = Dinglemouse.theLift(queues,5);
        assertArrayEquals(new int[]{0,2,5,0}, result);
    }

    @Test
    public void testUpAndUp() {
        final int[][] queues = {
                new int[0], // G
                new int[]{3}, // 1
                new int[]{4}, // 2
                new int[0], // 3
                new int[]{5}, // 4
                new int[0], // 5
                new int[0], // 6
        };
        final int[] result = Dinglemouse.theLift(queues,5);
        assertArrayEquals(new int[]{0,1,2,3,4,5,0}, result);
    }

    @Test
    public void testDownAndDown() {
        final int[][] queues = {
                new int[0], // G
                new int[]{0}, // 1
                new int[0], // 2
                new int[0], // 3
                new int[]{2}, // 4
                new int[]{3}, // 5
                new int[0], // 6
        };
        final int[] result = Dinglemouse.theLift(queues,5);
        assertArrayEquals(new int[]{0,5,4,3,2,1,0}, result);
    }

    @Test
    public void testUpAndDown() {
        final int[][] queues = {
                new int[]{6,6,6,6,6}, // G
                new int[0], // 1
                new int[0], // 2
                new int[0], // 3
                new int[0], // 4
                new int[0], // 5
                new int[]{0,0,0,0,0}, // 6
        };
        final int[] result = Dinglemouse.theLift(queues,5);
        assertArrayEquals(new int[]{0,6,0}, result);
    }

    @Test
    public void fireDrill() {
        final int[][] queues = {
                new int[]{6,6,6,6,6}, // G
                new int[0], // 1
                new int[0], // 2
                new int[0], // 3
                new int[0], // 4
                new int[0], // 5
                new int[]{0,0,0,0,0}, // 6
        };
        final int[] result = Dinglemouse.theLift(queues,0);
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    public void fullLift() {
        final int[][] queues = {
                new int[]{6,6,6,6,6}, // G
                new int[]{5,5,5,5}, // 1
                new int[0], // 2
                new int[0], // 3
                new int[0], // 4
                new int[0], // 5
                new int[]{0,0,0,0,0}, // 6
        };
        final int[] result = Dinglemouse.theLift(queues,5);
        assertArrayEquals(new int[]{0,1,6,0,1,5,0}, result);
    }
}
