package com.personal.crownvalor.entities;

import com.personal.crownvalor.enums.Direction;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table (name = "map")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private Long id; //The id of the room.
    @ElementCollection
    @CollectionTable(name = "available_directions", joinColumns = @JoinColumn(name = "room_id")) //this makes a separate table for the directions, joining them to the room by the room_id.
    @MapKeyColumn(name = "direction") //This is the key for the map.
    @Column(name = "is_available") //This is the value for the map.
    private Map<Direction, Boolean> availableDirections = new HashMap<>(); //This is a map that tells us which directions are available to move to.
    private Door door; //The door that is in the room.
    //We don't need to use the @ElementCollection below because Enemy is an entity. Direction is not an entity.
    @OneToMany //Define relationship between Enemy and Room. One room can have many enemies.
    @JoinColumn(name = "room_id") //This is the foreign key that joins the enemy to the room.
    List<Zombie> zombiesInRoom; //The enemies that are in the room.
    //Chest chest; //The chest that is in the room.


}
