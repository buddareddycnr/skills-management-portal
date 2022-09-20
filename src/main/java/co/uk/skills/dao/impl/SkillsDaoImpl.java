package co.uk.skills.dao.impl;

import co.uk.skills.constants.ConstantMessage;
import co.uk.skills.dao.SkillsDao;
import co.uk.skills.entity.Skill;
import co.uk.skills.exception.*;
import co.uk.skills.repository.SkillsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SkillsDaoImpl implements SkillsDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(SkillsDaoImpl.class);
    private SkillsRepository skillsRepository;

    @Value("${skill.maximum.allowedSkills.perCustomer}")
    private int maximumAllowedSkillsPerCustomer;

    @Autowired
    public SkillsDaoImpl(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    /**
     * @param skill
     * @return
     */
    @Override
    public Skill saveSkill(Skill skill) {
        try {
            if(maximumAllowedSkillsPerCustomer>=skillsRepository.countById(skill.getId()))
            return skillsRepository.saveAndFlush(skill);
            else
                throw new ExceedMaximumAllowedSkillsException("Not possible add more than limit");
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while saving the skills details {}",exception);
            throw new ExceedMaximumAllowedSkillsException("Not possible add more than limit", exception);
        }
    }

    /**
     * @param skill
     * @return
     */
    @Override
    public Skill updateSkill(Skill skill) {
        try {
            return skillsRepository.saveAndFlush(skill);
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while updating the skills details {}",exception);
            throw new SaveOrUpdateOperationFailedException("Update operation failed for skill", exception);
        }
    }

    /**
     * @return
     */
    @Override
    public List<Skill> getAll() {
        try {
            return skillsRepository.findAll();
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while fetching all skills data {}",exception);
            throw new UnknownException("Failed to get all skills details ", exception);
        }
    }

    /**
     * @param customerId
     * @return
     */
    @Override
    public List<Skill> getSkillsByCustomerId(long customerId) {
        try {
            return skillsRepository.findById(customerId);
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while fetching skills by customer id {}",exception);
            throw new UnknownException("Failed to get all skills details by customer id ", exception);
        }

    }

    /**
     * @param skillId
     * @return
     */
    @Override
    public String deleteSkill(long skillId) {
        try {
            skillsRepository.deleteById(skillId);
            return ConstantMessage.DELETE_RECORD_MESSAGE_SUCCESS;
        }catch (Exception exception){
            LOGGER.error("Exception occurred while deleting skills by id {}",exception);
            throw new DeleteOperationFailedException("Failed to delete skill by skillId ",exception);
        }
    }

    /**
     * @param customerId
     * @return
     */
    @Override
    public String deleteAllSkillsByCustomerId(long customerId) {
        try {
            skillsRepository.deleteAllById(customerId);
            return ConstantMessage.DELETE_RECORD_MESSAGE_SUCCESS;
        }catch (Exception exception){
            LOGGER.error("Exception occurred while delete all skills by customer id {}",exception);
            throw new DeleteOperationFailedException("Failed to delete all skills by customer id ",exception);
        }
    }
}
