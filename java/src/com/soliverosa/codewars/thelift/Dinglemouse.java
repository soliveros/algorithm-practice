package com.soliverosa.codewars.thelift;

import java.util.*;

public class Dinglemouse {
    static Build build;
    public static Build  init(final int[][] queues, final int capacity) {
        build= new Build();
        for (int i = 0; i < queues.length; i++) {
            Floor floor = new Floor(i, queues[i]);
            build.addFloor(floor);
        }
        Lift lift = new Lift(capacity);
        build.addLift(capacity);
        return build;
    }

    public static int[] theLift(final int[][] queues, final int capacity) {
        int[] a = {};
        if(capacity == 0) {
            return new int[]{0};
        }
        Build build = init(queues, capacity);
        while (build.areTherePeopleWaitingLift()) {
            build.getLift().up(build.getFloors());
            build.getLift().down(build.getFloors());
        }
        ArrayList<Integer> stoppedFloors = build.getLift().getStoppedFloors();
        if(stoppedFloors.get(stoppedFloors.size()-1) != 0){
            build.getLift().sleep();
        }
        return build.getLift().getStoppedFloors().stream().mapToInt( i -> i).toArray();
    }
}

class Lift {
    private int maxCapacity;
    private int currentFloor;
    private ArrayList<Integer> stoppedFloors;
    private List<Passenger> passengersOnBoard;
    private String direction;

    Lift(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengersOnBoard = new ArrayList<Passenger>();
        stoppedFloors = new ArrayList<Integer>();
        currentFloor = 0;
        stoppedFloors.add(currentFloor);
    }

    public void up(Queue<Floor> floors) {
        this.setDirection("up");
        Iterator<Floor> it = floors.iterator();
        while (it.hasNext()) {
            boolean goDownPassengers = false;
            boolean goUpPassengers = false;
            Floor floor = it.next();
            this.currentFloor = floor.getFloorNumber();
            if(havePassengerForThisFloor(floor.getFloorNumber())) {
                goDownPassengers = this.goDownPassengers(floor);
            }
            if(!floor.getFloorQueue().isEmpty()) {
                goUpPassengers = this.goUpPassengers(floor);
            }
            if(goDownPassengers || goUpPassengers) {
                if(this.stoppedFloors.get(this.stoppedFloors.size()-1) != floor.getFloorNumber()) {
                    this.stoppedFloors.add(floor.getFloorNumber());
                }
            }
        }
    }

    public void down(LinkedList<Floor> floors) {
        this.setDirection("down");
        Iterator<Floor> it = floors.descendingIterator();
        while (it.hasNext()) {
            boolean goDownPassengers = false;
            boolean goUpPassengers = false;
            Floor floor = it.next();
            this.currentFloor = floor.getFloorNumber();
            if(havePassengerForThisFloor(floor.getFloorNumber())) {
                goDownPassengers = this.goDownPassengers(floor);
            }
            if(!floor.getFloorQueue().isEmpty()) {
                goUpPassengers = this.goUpPassengers(floor);
            }
            if(goDownPassengers || goUpPassengers) {
                if(this.stoppedFloors.get(this.stoppedFloors.size()-1) != floor.getFloorNumber()) {
                    this.stoppedFloors.add(floor.getFloorNumber());
                }
            }
        }
    }

    public boolean goUpPassengers(Floor floor) {
        boolean stop = false;
        Iterator<Passenger> it = floor.getFloorQueue().iterator();
        while (it.hasNext()) {
            Passenger passenger = it.next();
                if(this.direction.equals("up")) {
                    if(passenger.getFloorNumberTo() > this.currentFloor) {
                        stop = true;
                        if(this.passengersOnBoard.size() < this.maxCapacity) {
                            it.remove();
                            this.passengersOnBoard.add(passenger);
                        }
                    }
                } else if (this.direction.equals("down")) {
                    if(passenger.getFloorNumberTo() < this.currentFloor) {
                        stop = true;
                        if(this.passengersOnBoard.size() < this.maxCapacity) {
                            it.remove();
                            this.passengersOnBoard.add(passenger);
                        }
                    }
                }
        }
        return stop;
    }

    public boolean goDownPassengers(Floor floor) {
        boolean stop = false;
        Iterator<Passenger> it = passengersOnBoard.iterator();
        while(it.hasNext()) {
            Passenger passenger = it.next();
            if(passenger.getFloorNumberTo() == floor.getFloorNumber()) {
                stop = true;
                it.remove();
            }
        }
        return stop;
    }

    private boolean havePassengerForThisFloor(int floorNumber) {
        Iterator<Passenger> it = passengersOnBoard.iterator();
        while(it.hasNext()) {
            Passenger passenger = it.next();
             if(passenger.getFloorNumberTo() == floorNumber) {
                 return true;
             }
        }
        return false;
    }

    public void sleep() {
        this.currentFloor = 0;
        this.stoppedFloors.add(0);
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ArrayList<Integer> getStoppedFloors() {
        return stoppedFloors;
    }

    public void setStoppedFloors(ArrayList<Integer> stoppedFloors) {
        this.stoppedFloors = stoppedFloors;
    }

    public List<Passenger> getPassengersOnBoard() {
        return passengersOnBoard;
    }

    public void setPassengersOnBoard(List<Passenger> passengersOnBoard) {
        this.passengersOnBoard = passengersOnBoard;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}

class Build {
    private LinkedList<Floor> floors;
    private Lift lift;
    Build() {
        floors = new LinkedList<Floor>();
    }

    public void addFloor(Floor floor) {
        this.floors.add(floor);
    }

    public void addLift(int liftCapacity){
        lift = new Lift(liftCapacity);
    }

    public boolean areTherePeopleWaitingLift() {
        Iterator<Floor> it = floors.iterator();
        while(it.hasNext()){
            Floor floor = it.next();
            if (floor.getFloorQueue().size() > 0) {
               return true;
            }
        }
        return false;
    }

    public LinkedList <Floor> getFloors() {
        return floors;
    }

    public void setFloors(LinkedList floors) {
        this.floors = floors;
    }

    public Lift getLift() {
        return lift;
    }

    public void setLift(Lift lift) {
        this.lift = lift;
    }
}

class Floor {
    private int floorNumber;
    private Queue<Passenger> floorQueue;

    Floor(int floorNumber, int[] queue) {
        this.floorNumber = floorNumber;
        floorQueue = new LinkedList<Passenger>();
        for (int i = 0; i < queue.length; i++) {
            Passenger passenger = new Passenger(floorNumber, queue[i]);
            floorQueue.add(passenger);
        }
    }

    public Queue<Passenger> getFloorQueue() {
        return floorQueue;
    }

    public void setFloorQueue(Queue<Passenger> floorQueue) {
        this.floorQueue = floorQueue;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}

class Passenger {
    private int floorNumberFrom;
    private int floorNumberTo;

    Passenger(int floorNumberFrom, int floorNumberTo) {
        this.floorNumberFrom = floorNumberFrom;
        this.floorNumberTo = floorNumberTo;
    }

    public int getFloorNumberFrom() {
        return floorNumberFrom;
    }

    public void setFloorNumberFrom(int floorNumberFrom) {
        this.floorNumberFrom = floorNumberFrom;
    }

    public int getFloorNumberTo() {
        return floorNumberTo;
    }

    public void setFloorNumberTo(int floorNumberTo) {
        this.floorNumberTo = floorNumberTo;
    }

}

