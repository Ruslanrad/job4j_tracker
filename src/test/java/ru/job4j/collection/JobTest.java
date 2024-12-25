package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorAscByName() {
        List<Job> jobs = new ArrayList<>();
        Job job1 = new Job("AFix bug", 2);
        Job job2 = new Job("Fix bug", 5);
        Job job3 = new Job("Impl task", 0);
        Job job4 = new Job("ZFix bug", 3);
        jobs.add(job1);
        jobs.add(job4);
        jobs.add(job2);
        jobs.add(job3);
        List<Job> expectedJobs = new ArrayList<>();
        expectedJobs.add(job1);
        expectedJobs.add(job2);
        expectedJobs.add(job3);
        expectedJobs.add(job4);
        jobs.sort(new JobAscByName());
        assertThat(jobs).containsSequence(expectedJobs);
    }

    @Test
    public void whenComparatorDescByName() {
        List<Job> jobs = new ArrayList<>();
        Job job1 = new Job("AFix bug", 2);
        Job job2 = new Job("Fix bug", 5);
        Job job3 = new Job("Impl task", 0);
        Job job4 = new Job("ZFix bug", 3);
        jobs.add(job1);
        jobs.add(job4);
        jobs.add(job2);
        jobs.add(job3);
        List<Job> expectedJobs = new ArrayList<>();
        expectedJobs.add(job4);
        expectedJobs.add(job3);
        expectedJobs.add(job2);
        expectedJobs.add(job1);
        jobs.sort(new JobDescByName());
        assertThat(jobs).containsSequence(expectedJobs);
    }

    @Test
    public void whenComparatorAscByPriority() {
        List<Job> jobs = new ArrayList<>();
        Job job1 = new Job("AFix bug", 2);
        Job job2 = new Job("Fix bug", 5);
        Job job3 = new Job("Impl task", 0);
        Job job4 = new Job("ZFix bug", 3);
        jobs.add(job1);
        jobs.add(job4);
        jobs.add(job2);
        jobs.add(job3);
        List<Job> expectedJobs = new ArrayList<>();
        expectedJobs.add(job3);
        expectedJobs.add(job1);
        expectedJobs.add(job4);
        expectedJobs.add(job2);
        jobs.sort(new JobAscByPriority());
        assertThat(jobs).containsSequence(expectedJobs);
    }

    @Test
    public void whenComparatorDescByPriority() {
        List<Job> jobs = new ArrayList<>();
        Job job1 = new Job("AFix bug", 2);
        Job job2 = new Job("Fix bug", 5);
        Job job3 = new Job("Impl task", 0);
        Job job4 = new Job("ZFix bug", 3);
        jobs.add(job1);
        jobs.add(job4);
        jobs.add(job2);
        jobs.add(job3);
        List<Job> expectedJobs = new ArrayList<>();
        expectedJobs.add(job2);
        expectedJobs.add(job4);
        expectedJobs.add(job1);
        expectedJobs.add(job3);
        jobs.sort(new JobDescByPriority());
        assertThat(jobs).containsSequence(expectedJobs);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}