package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.BookingEntity;
import com.project.hackathon.entity.CreatorEntity;
import com.project.hackathon.entity.PositionEntity;
import com.project.hackathon.repository.BookingRepository;
import com.project.hackathon.repository.CreatorRepository;
import com.project.hackathon.repository.PositionRepository;
import com.project.hackathon.request.LoginRequest;
import com.project.hackathon.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreatorServiceImpl implements CreatorService {
    @Autowired
    private CreatorRepository creatorRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    public BookingRepository bookingRepository;

    @Override
    public List<CreatorEntity> getCreators() {
        return creatorRepository.findAll();
    }

    @Override
    public Long createCreator(CreatorEntity creator) {
        return creatorRepository.save(creator).getId();
    }

    @Override
    public Optional<CreatorEntity> getCreatorById(Long creatorId) {
        return creatorRepository.findById(creatorId);
    }

    @Override
    public List<PositionEntity> getPositionsByCreator(CreatorEntity creator) {
        return positionRepository.findPositionsByCreatorId(creator);
    }

    @Override
    public CreatorEntity login(LoginRequest creator) {
        String mailCheck = creator.getUserEmail();
        String passwordCheck = creator.getUserPassword();

        Optional<CreatorEntity> personOptional = creatorRepository.findByEmail(mailCheck);

        if (personOptional.isEmpty()) {
            return null;  // Пользователь не найден
        }

        CreatorEntity creatorEntity = personOptional.get();

        if (creatorEntity.getPassword().equals(passwordCheck)) {
            return creatorEntity; // Пароль верный, возвращаем пользователя
        } else {
            return null; // Неверный пароль
        }

    }

    @Override
    public List<BookingEntity> getBookingsByCreator(CreatorEntity creator) {
        List<PositionEntity> positions = positionRepository.findPositionsByCreatorId(creator);
        List<BookingEntity> result = new ArrayList<>();
        if (positions != null && !positions.isEmpty()) {
            for (PositionEntity position : positions) {
                System.out.println(position);
                List<BookingEntity> bookingsForPosition = bookingRepository.findByPositionId(position);
                if (bookingsForPosition != null) {
                    result.addAll(bookingsForPosition);
                }
            }
        }
        return result;
    }
}
