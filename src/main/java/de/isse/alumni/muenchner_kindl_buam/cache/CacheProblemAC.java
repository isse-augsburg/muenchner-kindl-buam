package de.isse.alumni.muenchner_kindl_buam.cache;

import java.net.URI;

import de.isse.alumni.muenchner_kindl_buam.cache.data.Allocation;
import de.isse.alumni.muenchner_kindl_buam.cache.data.Input;
import de.isse.alumni.muenchner_kindl_buam.cache.output.AllocationWriter;
import de.isse.alumni.muenchner_kindl_buam.cache.solver.GreedySolverAC;
import de.isse.alumni.muenchner_kindl_buam.cache.solver.Solver;

public class CacheProblemAC {
	public static void main(String[] args) throws Exception {
		String problem1 = "me_at_the_zoo";
		String problem2 = "trending_today";
		String problem3 = "videos_worth_spreading";
		String problem4 = "kittens";
		String problem = problem4;
		if (args.length > 0) {
			problem = args[0];
		}
		System.out.println("Processing problem " + problem);

		final CacheProblemAC app = new CacheProblemAC();
		app.run(problem);
	}

	void run(String problem) throws Exception {
		final URI problemFile = getClass().getClassLoader().getResource("datacenters/" + problem + ".in").toURI();
		final ProblemSetReader reader = new ProblemSetReader(problemFile);
		final Input input = reader.parseInputFile();
		final Solver solver = new GreedySolverAC();

		final Allocation allocation = solver.solve(input);
		final String resultFileName = String.format("%s_%s.out", problem, solver.getClass().getSimpleName());
		AllocationWriter.write(allocation, resultFileName);

		System.out.println(allocation.getScore());
	}
}
