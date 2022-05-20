package ru.runnerlite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.runnerlite.entities.dto.RunningResultDto;
import ru.runnerlite.repositories.RunningResultRepository;
import ru.runnerlite.repositories.SecUserRepository;
import ru.runnerlite.repositories.TeamsRunningCountRepository;
import ru.runnerlite.services.interfaces.IRunningResultsService;

import java.util.List;

@Service
public class RunningResultsService implements IRunningResultsService {

    private final RunningResultRepository runningResultRepository;
    private final SecUserService userService;
    private final TeamsRunningCountRepository runningRepository;
    private final SecUserRepository secUserRepository;

    @Autowired
    public RunningResultsService(RunningResultRepository runningResultRepository, SecUserService userService, TeamsRunningCountRepository runningRepository, SecUserRepository secUserRepository) {
        this.runningResultRepository = runningResultRepository;
        this.userService = userService;
        this.runningRepository = runningRepository;
        this.secUserRepository = secUserRepository;
    }

    @Override
    public List<RunningResultDto> findAllResult() {
        List<RunningResultDto> runningResult = runningResultRepository.findAllResult();
        return runningResult;
    }
    
    @Override
    public RunningResultDto getLastRunningResult(String currentUserName) {
        List<RunningResultDto> runningResult = runningResultRepository.findLastResult(currentUserName, PageRequest.of(0,1));
        if (runningResult == null) {
            throw new IllegalArgumentException("Пользователь с id = " + currentUserName + " не найден.");
        }
        return runningResult.get(0);
    }
}
