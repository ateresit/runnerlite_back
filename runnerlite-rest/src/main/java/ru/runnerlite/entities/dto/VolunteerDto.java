package ru.runnerlite.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerDto  implements Serializable {
    private Integer id; //id волонтера
    private Integer userId; //id user
    private String fullName; //полное имя волонтера
    private Boolean status; //статус запроса
    private Instant runningDate; //дата забега
    private Integer runningNumber; //номер забега
    private String positionName; //позиция волонтера
    private String positionDescription; //описание позиции волонтера
    private String teamsName; //имя команды
    private Integer teamsId; //для логотипа
    private Long runningNumberСount; //колчиство забегов в качестве волонтера
    private List<String> positionNameHistory; //исторический список позиций волонтера

    public VolunteerDto(Integer id, Integer userId, String fullName, Boolean status, Instant runningDate, Integer runningNumber, String positionName, String positionDescription, String teamsName, Integer teamsId) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.status = status;
        this.runningDate = runningDate;
        this.runningNumber = runningNumber;
        this.positionName = positionName;
        this.positionDescription = positionDescription;
        this.teamsName = teamsName;
        this.teamsId = teamsId;
    }

    public VolunteerDto(Integer id, Integer userId, String fullName, Boolean status, String positionName, String positionDescription) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.status = status;
        this.positionName = positionName;
        this.positionDescription = positionDescription;
    }
}
