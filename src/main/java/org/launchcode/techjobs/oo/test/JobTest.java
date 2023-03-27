package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        Assert.assertNotEquals(job1.getId(),job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job testjob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertTrue(testjob.getName() instanceof String);
        Assert.assertTrue(testjob.getEmployer() instanceof Employer);
        Assert.assertTrue(testjob.getLocation() instanceof Location);
        Assert.assertTrue(testjob.getPositionType() instanceof PositionType);
        Assert.assertTrue(testjob.getCoreCompetency() instanceof CoreCompetency);

        Assert.assertEquals("Product tester", testjob.getName());
        Assert.assertEquals("ACME", testjob.getEmployer().getValue());
        Assert.assertEquals("Desert", testjob.getLocation().getValue());
        Assert.assertEquals("Quality control", testjob.getPositionType().getValue());
        Assert.assertEquals("Persistence", testjob.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job();
        Job job2 = new Job();
        Assert.assertNotEquals(job1,job2);
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobString = testJob.toString();
        char firstChar = testJob.toString().charAt(0);
        char lastChar = testJob.toString().charAt(testJob.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');

    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobString = testJob.toString();
        Assert.assertTrue(jobString.contains("Name: Product tester"));
        Assert.assertTrue(jobString.contains("Employer: ACME"));
        Assert.assertTrue(jobString.contains("Location: Desert"));
        Assert.assertTrue(jobString.contains("PositionType: Quality control"));
        Assert.assertTrue(jobString.contains("CoreCompetency: Persistence"));

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobString = testJob.toString();
        Assert.assertTrue(jobString.contains("Data Not Available"));
    }
}
