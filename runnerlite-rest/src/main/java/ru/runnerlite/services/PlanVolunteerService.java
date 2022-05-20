package ru.runnerlite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.runnerlite.entities.RefVolunteersPosition;
import ru.runnerlite.entities.SecUser;
import ru.runnerlite.entities.TeamsRunningCount;
import ru.runnerlite.entities.Volunteer;
import ru.runnerlite.entities.dto.PlanVolunteerDto;
import ru.runnerlite.entities.dto.VolunteerDto;
import ru.runnerlite.repositories.*;
import ru.runnerlite.services.interfaces.IPlanVolunteerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanVolunteerService implements IPlanVolunteerService {

    private TeamsVolunteerRepository teamsVolunteerRepository;
    private VolunteerRepository volunteerRepository;
    private SecUserRepository secUserRepository;
    private TeamsRunningCountRepository teamsRunningCountRepository;
    private RefVolunteersPositionRepository refVolunteersPositionRepository;

    @Autowired
    public PlanVolunteerService(TeamsVolunteerRepository teamsVolunteerRepository, VolunteerRepository volunteerRepository, SecUserRepository secUserRepository, TeamsRunningCountRepository teamsRunningCountRepository, RefVolunteersPositionRepository refVolunteersPositionRepository) {
        this.teamsVolunteerRepository = teamsVolunteerRepository;
        this.volunteerRepository = volunteerRepository;
        this.secUserRepository = secUserRepository;
        this.teamsRunningCountRepository = teamsRunningCountRepository;
        this.refVolunteersPositionRepository = refVolunteersPositionRepository;
    }

    //получения таблицы с информацией о потребности в волонтерах
    @Override
    public List<PlanVolunteerDto> findPlanVolunteer(Integer teamsRunningCountId) {
        List<VolunteerDto> volunteers = volunteerRepository.findVolunteerByTeamsRunningCountId(teamsRunningCountId);
        List<PlanVolunteerDto> planVolunteers = teamsVolunteerRepository.findPlanVolunteer(teamsRunningCountId);
        List<PlanVolunteerDto> list= new ArrayList<>();
        for (PlanVolunteerDto planVolunteer: planVolunteers) {
            for (VolunteerDto volunteer : volunteers) {
                if (planVolunteer.getPositionName().equals(volunteer.getPositionName())){
                    planVolunteer.setId(volunteer.getId());
                    planVolunteer.setUserId(volunteer.getUserId());
                    planVolunteer.setFullNameVolunteer(volunteer.getFullName());
                    planVolunteer.setParticipationStatus(volunteer.getStatus());
                }
            }
            list.add(planVolunteer);
        }
        return list;
    }

    // отмена участия в забеге в качестве волонтера
    @Override
    public void deleteVolunteerFromRun(Integer volunteersId) {
        volunteerRepository.deleteById(volunteersId);
    }

    // запись для участия в забеге в качестве волонтера
    @Override
    public void insertVolunteerFromRun(String currentUserName, Integer teamsRunningCountId, Integer volunteersPosition) {
        Optional<SecUser> userId = secUserRepository.findByUsername(currentUserName);
        TeamsRunningCount teamsRunningCount = teamsRunningCountRepository.getById(teamsRunningCountId);
        RefVolunteersPosition refVolunteersPosition = refVolunteersPositionRepository.getById(volunteersPosition);
        Volunteer volunteer = new Volunteer(null, userId.get(),false, refVolunteersPosition, teamsRunningCount);
        volunteerRepository.save(volunteer);
    }
}
