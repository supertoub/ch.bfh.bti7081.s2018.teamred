package ch.bfh.saa;

import Data.GenericDataFacade;
import Data.GenericDataFacadeJPA;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import Business.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.logging.Level;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationcontext.xml")
@Transactional
public class DataFacadeTest extends TestCase {

        @PersistenceContext
        private EntityManager entityManager;

        public void setUp() throws Exception {
            super.setUp();
        }

        @Test
        public void genericDAOShouldSaveAChallengeEntity() throws Exception {
            // Save a person
            GenericDataFacade<Challenge, Long> challengeDao = new GenericDataFacadeJPA<>(Challenge.class);

            challengeDao.setEntityManager(entityManager);
            Challenge challenge = new Challenge("aaa", "bbb", ChallengeState.open, 1);
            challenge = challengeDao.save(challenge);

            Challenge anotherChallenge = challengeDao.get(challenge.getId());

            assertThat(anotherChallenge, is(equalTo(challenge)));
        }
}