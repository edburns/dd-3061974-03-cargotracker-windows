# Copilot CLI Session

> [!NOTE]
> - **Session ID:** `3e299281-04ac-4696-b0a2-ab5c7098d6f3`  
> - **Started:** 9/10/2026, 10:21:15 AM  
> - **Duration:** 4m 33s  
> - **Exported:** 9/10/2026, 10:25:49 AM  

---

<sub>2s</sub>

### User

Invoke skill `shepherd-task-20-create-issues-from-plan` with these inputs:

- CAMPAIGN_ID: e79d621c-3af9-4238-8f51-fde34dde1e94
- LESSON_PROPAGATION: off
- REPO: edburns/dd-3061974-03-cargotracker-windows
- BASE_BRANCH: experiment/shepherd-control
- PARENT_ISSUE: 1
- PLAN_DIRECTORY: 1-arrival-deadline-control-remove-before-merge
- PLAN_FILE_NAME: add-change-arrival-deadline-feature-ignorance-reduction-plan.md
- QUESTIONS_SECTION: ## Phase 3 — Ignorance reduction: questions to answer before writing code
- IMPLEMENTATION_SECTION: ## Phase 4 — Implementation (five serial issues)
- EXPECTED_TASK_COUNT: 5
- BASE_REMOTE: origin
- LOG_DIRECTORY: C:\Users\edburns\workareas\dd-3061974-03-cargotracker-windows-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260910-1021
- DRAFT_VALIDATOR: C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\validate-stage20-drafts.ps1
- ISSUE_BODY_VERIFIER: C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-github-issue-body.ps1

Fixture pagination response contract (mandatory):

- `gh api ... --paginate --slurp` returns a JSON array of page payloads, so a
  one-page response has the shape `[[{...}]]`, not `[{...}]`.
- Before indexing child issue fields such as `.id`, normalize the response to
  one flat issue array exactly once.
- In Bash, use:
  `jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end'`.
- In PowerShell, capture the `gh` output and `$LASTEXITCODE` first, then pass
  the complete JSON through the same `jq` normalization before
  `ConvertFrom-Json`.
- Use the normalized flat array for the pre-creation baseline, final child
  count/order checks, and failure reconciliation. Do not apply `add` a second
  time to an already-flat array.


---

<sub>6s</sub>

### `skill`

**shepherd-task-20-create-issues-from-plan**

<details>
<summary>Arguments</summary>

```json
{
  "skill": "shepherd-task-20-create-issues-from-plan"
}
```

</details>

```
Skill "shepherd-task-20-create-issues-from-plan" loaded successfully. Follow the instructions in the skill context.
```


---

<sub>11s</sub>

### Copilot

I’m validating the campaign inputs, plan structure, research evidence, repository capabilities, and existing child baseline before drafting any GitHub mutations.

---

<sub>35s</sub>

### `sql`

**Track stage twenty work**

<details>
<summary>Arguments</summary>

```json
{
  "description": "Track stage twenty work",
  "query": "INSERT INTO todos (id, title, description, status) VALUES ('validate-stage20', 'Validating stage 20 inputs', 'Validate repository, branch, parent, plan, campaign manifest, validators, examples, and child baseline.', 'in_progress'), ('draft-stage20', 'Drafting ordered issues', 'Build traceability map and persist five complete issue bodies, ledger, and in-progress result.', 'pending'), ('create-stage20', 'Creating linked issues', 'Validate drafts, create and body-verify/link five issues serially while persisting ledger.', 'pending'), ('verify-stage20', 'Verifying stage postconditions', 'Verify child ordering, bodies, open/unassigned status, issue type, and write complete result.', 'pending'); INSERT INTO todo_deps (todo_id, depends_on) VALUES ('draft-stage20','validate-stage20'), ('create-stage20','draft-stage20'), ('verify-stage20','create-stage20')"
}
```

</details>

<details>
<summary>5 lines</summary>

```
Executed 2 statement(s):

1. INSERT
   4 row(s) inserted. Last inserted row ID: 4.

2. INSERT
   3 row(s) inserted. Last inserted row ID: 3.
```

</details>


---

<sub>35s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\01-1682-java-tool-ergonomics.md.**

C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\01-1682-java-tool-ergonomics.md

<details>
<summary>15 lines</summary>

```
# Example 01: 1682-java-tool-ergonomics-prompts-remove-before-merge

Read `copilot-sdk/1682-java-tool-ergonomics-prompts-remove-before-merge/dd-3018003-ignorance-reduction-for-implementation-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 3 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating issues of type **Task** as children of Epic https://github.com/github/copilot-sdk/issues/1682 . These issues correspond to the sub-sections in `## Phase 4 — Implementation (the build order)`.

I want you to use `gh` to create issues as sub-issues of 1682.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Set the type to **Task**.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `upstream`: `edburns/1682-java-tool-ergonomics`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `1682-java-tool-ergonomics-prompts-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**, I want you to carefully consider if there additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>36s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\02-1810-java-tool-as-lambda.md.**

C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\02-1810-java-tool-as-lambda.md

<details>
<summary>12 lines</summary>

```
# Example 02: 1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge

Carefully read the plan `copilot-sdk/1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`.

We have completed Phases 1 - 3. We are now on Phase 4.

For each sub item in Phase 4, file a child issue of Feature #1810.

Use `gh` to look at Epic #1682 and its child issues for the standard of verbosity and concreteness for issue descriptions.

The issue should be assignable to a coding agent and there must be sufficient detail in the description for the agent to proceed to completion.

Pull out the specific relevant content from Phase 3 as it applies to this current issue in Phase 4.

Tell the agent to take `edburns/1810-java-tool-ergonomics-tool-as-lambda` as the base branch. When I assign the issue to the coding agent, I will set this as the base branch.

Tell the agent to read `1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`, which is present on the branch, for context.

Tell the agent which sub-item within Phase 4 they are solving.

Tell the agent that each issue will be assigned, resolved and merged to the base branch in the order in which they appear in the plan.

No work is to start until I assign each issue to the coding agent, in turn.
```

</details>


---

<sub>37s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\03-dd-3017826-java-real-estate-demo.md.**

C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\03-dd-3017826-java-real-estate-demo.md

<details>
<summary>14 lines</summary>

```
# Example 03: dd-3017826-java-real-estate-demo-remove-before-merge

Read `dd-3017826-java-real-estate-demo-remove-before-merge\dd-3017826-java-real-estate-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/2 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #2.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/2-build-out-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `dd-3017826-java-real-estate-demo-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>36s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\04-28-python-agent-demo.md.**

C:\Users\edburns\.copilot\skills\shepherd-task-20-create-issues-from-plan\examples\04-28-python-agent-demo.md

<details>
<summary>16 lines</summary>

```
# Example 04: 28-python-agent-demo-remove-before-merge

Read `28-python-agent-demo-remove-before-merge/28-python-agent-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`. These pertain to the implementation tasks in Phase 3. ✅✅✅ Make sure to put into the description explicit instructions on how to access the relevant spike research.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/28 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #28

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Again, ✅✅For each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`, include the relevant Resolution values in the issue description. These pertain to the implementation tasks in Phase 3. ✅✅✅ Make sure to put into the description explicit instructions on how to access the relevant spike research for that task.

- For tasks dealing with the UI, make sure to refer to the relevant screengrabs, but only ones within `28-python-agent-demo-remove-before-merge/`.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/28-python-agent-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `28-python-agent-demo-remove-before-merge/`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>38s</sub>

### `powershell`

**Validate local inputs and branch**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; $logDir='C:\\Users\\edburns\\workareas\\dd-3061974-03-cargotracker-windows-shepherd-control\\1-arrival-deadline-control-remove-before-merge\\prompts\\shepherd-task-20-20260910-1021'; $validator='C:\\Users\\edburns\\.copilot\\plugins\\shepherd-task\\scripts\\validate-stage20-drafts.ps1'; $verifier='C:\\Users\\edburns\\.copilot\\plugins\\shepherd-task\\scripts\\verify-github-issue-body.ps1'; [pscustomobject]@{LogDirectoryExists=Test-Path -LiteralPath $logDir -PathType Container; LogDirectoryRooted=[IO.Path]::IsPathRooted($logDir); ValidatorExists=Test-Path -LiteralPath $validator -PathType Leaf; ValidatorRooted=[IO.Path]::IsPathRooted($validator); VerifierExists=Test-Path -LiteralPath $verifier -PathType Leaf; VerifierRooted=[IO.Path]::IsPathRooted($verifier); Jq=(Get-Command jq -ErrorAction SilentlyContinue).Source} | ConvertTo-Json; if (Test-Path -LiteralPath $logDir -PathType Container) { $probe=Join-Path $logDir '.write-probe'; [IO.File]::WriteAllText($probe,'ok'); Remove-Item -LiteralPath $probe; New-Item -ItemType Directory -Path (Join-Path $logDir 'issue-bodies') -Force | Out-Null }; git remote -v; git branch --show-current; git show-ref --verify refs/heads/experiment/shepherd-control; git symbolic-ref refs/remotes/origin/HEAD",
  "description": "Validate local inputs and branch",
  "initial_wait": 30,
  "mode": "sync"
}
```

</details>

<details>
<summary>17 lines</summary>

```
{
  "LogDirectoryExists": true,
  "LogDirectoryRooted": true,
  "ValidatorExists": true,
  "ValidatorRooted": true,
  "VerifierExists": true,
  "VerifierRooted": true,
  "Jq": "C:\\Users\\edburns\\AppData\\Local\\Microsoft\\WinGet\\Packages\\jqlang.jq_Microsoft.Winget.Source_8wekyb3d8bbwe\\jq.exe"
}
origin	git@github.com:edburns/dd-3061974-03-cargotracker-windows.git (fetch)
origin	git@github.com:edburns/dd-3061974-03-cargotracker-windows.git (push)
upstream	git@github.com:azure-javaee/cargotracker.git (fetch)
upstream	git@github.com:azure-javaee/cargotracker.git (push)
experiment/shepherd-control
3d7775b88429044a30ec563f0e3cee9bb245759a refs/heads/experiment/shepherd-control
refs/remotes/origin/20260902-2104Z-commit-e7b651f-liberty
<shellId: 2 completed with exit code 0>
```

</details>


---

<sub>37s</sub>

### `powershell`

**Read campaign plan from branch**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md'; if ($LASTEXITCODE -ne 0) { throw 'Unable to read plan from base branch.' }",
  "description": "Read campaign plan from branch",
  "initial_wait": 30,
  "mode": "sync"
}
```

</details>

<details>
<summary>11 lines</summary>

```
Output too large to read at once (33.5 KB). Saved to: C:\Users\edburns\AppData\Local\Temp\1789060909364-copilot-tool-output-15204-76413860-5a85-44d2-b81f-ccd2db90bc66.txt
Consider using tools like rg (for searching), head/tail (for viewing start/end), view with view_range (for specific sections), or jq (for JSON) to examine portions of the output.

Preview (first 500 chars):
# Implementation plan: Change Arrival Deadline Date (`eclipse-ee4j/cargotracker#64`)

Human DRI: Ed Burns
Starting commit: `9b9f311b2a3a2854bdac947593950d9edb6bca7d` (`Make the system ready for implementation`)
Working directory: repository root of the current campaign worktree
Runtime baseline: Java 17, Java EE 7 (`javax.*`), Open Liberty 26.0.0.8, PrimeFaces 8.0
Baseline run instructions: `README.md`
Baseline preparation: fixed source branch and immutable SHA validated by the campaign fixture

<shellId: 0 completed with exit code 0>
```

</details>


---

<sub>38s</sub>

### `powershell`

**Read manifest and resource list**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/shepherd-campaign.json'; if ($LASTEXITCODE -ne 0) { throw 'Unable to read campaign manifest.' }; git cat-file -e 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/campaign-lessons.md'; if ($LASTEXITCODE -ne 0) { throw 'Campaign lessons file missing.' }; git ls-tree -r --name-only experiment/shepherd-control -- '1-arrival-deadline-control-remove-before-merge'",
  "description": "Read manifest and resource list",
  "initial_wait": 30,
  "mode": "sync"
}
```

</details>

<details>
<summary>21 lines</summary>

```
{
  "schemaVersion": 1,
  "campaignId": "e79d621c-3af9-4238-8f51-fde34dde1e94",
  "campaignIssueNumber": 1,
  "campaignShortname": "arrival-deadline-control",
  "repository": "edburns/dd-3061974-03-cargotracker-windows",
  "baseBranch": "experiment/shepherd-control",
  "lessonPropagation": "off",
  "campaignMetadataDirectory": "1-arrival-deadline-control-remove-before-merge",
  "lessonsFile": "campaign-lessons.md",
  "createdBy": {
    "shepherdTaskVersion": "1.0.2",
    "stageOutcomeProtocolVersion": 1
  },
  "createdAt": "2026-09-10T17:21:10Z"
}
1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md
1-arrival-deadline-control-remove-before-merge/campaign-lessons.md
1-arrival-deadline-control-remove-before-merge/shepherd-campaign.json
1-arrival-deadline-control-remove-before-merge/shepherd-test-experiment.json
<shellId: 3 completed with exit code 0>
```

</details>


---

<sub>39s</sub>

### `powershell`

**Validate GitHub repository and baseline**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; $repo='edburns/dd-3061974-03-cargotracker-windows'; $parent=1; $repoOutput=& gh api \"repos/$repo\" 2>&1; $repoExit=$LASTEXITCODE; if($repoExit -ne 0){throw \"Repository lookup failed: $($repoOutput|Out-String)\"}; $repoData=($repoOutput|Out-String|ConvertFrom-Json); $issueOutput=& gh api \"repos/$repo/issues/$parent\" 2>&1; $issueExit=$LASTEXITCODE; if($issueExit -ne 0){throw \"Parent lookup failed: $($issueOutput|Out-String)\"}; $issueData=($issueOutput|Out-String|ConvertFrom-Json); $childrenOutput=& gh api \"repos/$repo/issues/$parent/sub_issues\" --paginate --slurp 2>&1; $childrenExit=$LASTEXITCODE; if($childrenExit -ne 0){throw \"Children lookup failed: $($childrenOutput|Out-String)\"}; $normalizedOutput=($childrenOutput|Out-String) | jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end'; $jqExit=$LASTEXITCODE; if($jqExit -ne 0){throw 'Child response normalization failed.'}; $children=@(($normalizedOutput|Out-String)|ConvertFrom-Json); [pscustomobject]@{ownerLogin=$repoData.owner.login;ownerType=$repoData.owner.type;defaultBranch=$repoData.default_branch;parentNumber=$issueData.number;parentState=$issueData.state;parentRepository=$issueData.repository_url;children=@($children|ForEach-Object{[pscustomobject]@{id=$_.id;number=$_.number;title=$_.title}})}|ConvertTo-Json -Depth 6",
  "description": "Validate GitHub repository and baseline",
  "initial_wait": 60,
  "mode": "sync"
}
```

</details>

<details>
<summary>10 lines</summary>

```
{
  "ownerLogin": "edburns",
  "ownerType": "User",
  "defaultBranch": "20260902-2104Z-commit-e7b651f-liberty",
  "parentNumber": 1,
  "parentState": "open",
  "parentRepository": "https://api.github.com/repos/edburns/dd-3061974-03-cargotracker-windows",
  "children": []
}
<shellId: 1 completed with exit code 0>
```

</details>


---

<sub>45s</sub>

### Copilot

The campaign is valid, the base branch is non-default, parent #1 is open with no existing children, and this user-owned repository will use untyped issues. I’m now extracting the exact resolved decisions and five serial task specifications into the traceability map.

---

<sub>53s</sub>

### `view`

**view the file at C:\Users\edburns\AppData\Local\Temp\1789060909364-copilot-tool-output-15204-76413860-5a85-44d2-b81f-ccd2db90bc66.txt.**

C:\Users\edburns\AppData\Local\Temp\1789060909364-copilot-tool-output-15204-76413860-5a85-44d2-b81f-ccd2db90bc66.txt (lines 1-260)

<details>
<summary>199 lines</summary>

````
# Implementation plan: Change Arrival Deadline Date (`eclipse-ee4j/cargotracker#64`)

Human DRI: Ed Burns
Starting commit: `9b9f311b2a3a2854bdac947593950d9edb6bca7d` (`Make the system ready for implementation`)
Working directory: repository root of the current campaign worktree
Runtime baseline: Java 17, Java EE 7 (`javax.*`), Open Liberty 26.0.0.8, PrimeFaces 8.0
Baseline run instructions: `README.md`
Baseline preparation: fixed source branch and immutable SHA validated by the campaign fixture
Historical issue: `eclipse-ee4j/cargotracker#64`

Related directories and files:

- `src/main/java/org/eclipse/cargotracker/application/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/`
- `src/main/webapp/admin/dialogs/`
- `src/main/webapp/admin/tables/listNotRouted.xhtml`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

---

## Goal

Add an Administration dashboard operation that lets a shipping administrator
change the arrival deadline of a cargo listed in the **Not Routed Cargo** table.
The operation must preserve Cargo Tracker's layered architecture:

1. The application service owns the domain mutation.
2. The booking facade shields the web layer from domain types.
3. A JSF backing bean loads and submits the editable date.
4. A PrimeFaces dynamic dialog presents the editor.
5. The existing Not Routed Cargo table opens the dialog and refreshes after a
   successful update.

### User-visible acceptance behavior

Using the stable sample cargo `DEF789`:

1. Start the application with Java 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Open `http://localhost:8080/cargo-tracker/`.
3. Select **Administration**.
4. Find `DEF789` in the **Not Routed Cargo** table.
5. The Deadline cell displays its date together with an edit icon.
6. Hovering over the deadline displays:
   `Click to change cargo arrival deadline date.`
7. Selecting the deadline opens a modal dialog titled **Change Deadline**.
8. The dialog displays the cargo's origin and destination as read-only
   context.
9. The date editor is initialized to the cargo's current arrival deadline.
10. Selecting a different date and pressing **Update** closes the dialog and
    refreshes the Administration view.
11. The new date is shown in the Not Routed Cargo table.
12. Reloading the page continues to show the new date for the lifetime of the
    running in-memory sample application.
13. Pressing **Cancel** closes the dialog without changing the deadline.

### Domain acceptance behavior

Changing the deadline must:

- locate the cargo by `TrackingId`;
- preserve its existing origin;
- preserve its existing destination;
- replace only the arrival deadline in its `RouteSpecification`;
- apply the specification through `Cargo.specifyNewRoute(...)`;
- preserve the currently assigned itinerary rather than silently discarding
  it;
- allow the domain model to recalculate routing status and delivery-derived
  values against the new route specification;
- persist the changed cargo through `CargoRepository.store(...)`.

### Hard scope constraints

- Begin from commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d`.
- Preserve Java EE 7 and the `javax.*` namespace.
- Preserve the Java 7 source/target level used by this historical codebase.
- Run the application on JDK 17 using the existing Open Liberty profile.
- Do not migrate the application to Jakarta EE 8+, Jakarta EE 9+, Spring, or a
  different UI framework.
- Do not replace the in-memory Derby configuration or the Open Liberty runtime.
- Do not redesign unrelated cargo booking, routing, destination editing,
  messaging, batch, REST, or persistence behavior.
- Do not copy commits or files from feature-bearing branches. This plan is the
  implementation specification.
- Implement the five build issues below in order. Each issue must be complete
  and gated before the next issue begins.

---

## Completed phases

### Phase 1 ✅ — Establish a runnable feature-absent baseline

- Commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d` is based on the historical
  feature-absent commit and contains only the compatibility work needed to run
  the sample on JDK 17 and Open Liberty.
- `./mvnw clean package -Popenliberty liberty:run` starts the application.
- The home page and Administration flows return HTTP 200.
- JSF view metadata is placed at `UIViewRoot` scope for MyFaces compatibility.
- The internal routing REST client works without a Jersey/MOXy classloading
  conflict.
- The scheduled batch job has the local authorization it needs.

### Phase 2 ✅ — Verify the before and after user experience

- Before implementation, `DEF789` appears in the Not Routed Cargo table with a
  plain-text deadline and no edit operation.
- The neighboring Destination column demonstrates the existing PrimeFaces
  dynamic-dialog interaction pattern.
- The desired after behavior has been manually exercised: open the deadline
  editor, choose a new date, update, refresh the table, and observe the
  persisted value.
- The historical architectural boundaries and affected files have been
  identified.

---

## Phase 3 — Ignorance reduction: questions to answer before writing code

Resolve these questions before production implementation begins. The
recommendations intentionally define the desired design closely enough that an
implementing agent should not need to invent a different architecture.

### 3.1 — Which cargos expose the edit operation?

**Question:** Should deadline editing be exposed for all cargos or only for
cargos displayed in the Not Routed Cargo table?

The requested feature originates in the Administration dashboard's Not Routed
Cargo table. Other tables represent routed, misrouted, claimed, or otherwise
progressed cargo. Adding the affordance to every table would expand the feature
and require additional business rules about changing deadlines after handling
has begun.

| Option | UI scope | Trade-off |
|--------|----------|-----------|
| A | Not Routed Cargo table only | Matches the requested feature and the established destination-edit affordance. |
| B | Every Administration cargo table | Broader capability, but introduces lifecycle and authorization questions outside the request. |
| C | Cargo details page only | Avoids table complexity but does not meet the requested dashboard interaction. |

The application-service operation itself does not need to encode a UI-table
restriction. It should accept a tracking ID and apply the domain mutation to
the located cargo. The presentation layer determines where the operation is
offered.

**Recommendation:** Option A. Add the edit affordance only to
`src/main/webapp/admin/tables/listNotRouted.xhtml`. Keep the application
operation generally usable for a valid cargo.

**Resolution:**

Select Option A. Expose the edit affordance only in
`src/main/webapp/admin/tables/listNotRouted.xhtml`. The application and facade
operations remain generally callable for any cargo that can be found by
tracking ID; they do not encode knowledge of dashboard table membership.

### 3.2 — What is the exact domain mutation?

**Question:** Should the feature mutate the existing `RouteSpecification`, add
a setter to `Cargo`, or replace the specification using the existing domain
operation?

`RouteSpecification` is a value object describing origin, destination, and
arrival deadline. The existing `changeDestination(...)` implementation already
establishes the correct pattern: create a replacement specification, call
`Cargo.specifyNewRoute(...)`, and store the aggregate.

Proposed application-service shape:

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

Proposed implementation:

```java
Cargo cargo = cargoRepository.find(trackingId);
RouteSpecification specification = new RouteSpecification(
        cargo.getOrigin(),
        cargo.getRouteSpecification().getDestination(),
        deadline);

cargo.specifyNewRoute(specification);
cargoRepository.store(cargo);
```

Calling `specifyNewRoute(...)` is significant. It lets the aggregate recalculate
delivery and routing status relative to the new specification. Direct field
mutation or a persistence-only update would bypass that behavior.

**Recommendation:** Replace the `RouteSpecification` through
`Cargo.specifyNewRoute(...)`. Preserve origin, destination, and itinerary.
Persist using the existing repository. Do not add a deadline setter to the
domain model.

**Resolution:**

Use the same aggregate-update pattern as `changeDestination(...)`. Add
`BookingService.changeDeadline(TrackingId, Date)` and implement it by loading
the cargo, constructing a new `RouteSpecification` from the existing origin,
existing destination, and supplied deadline, calling
`cargo.specifyNewRoute(...)`, and storing the cargo through
`cargoRepository.store(...)`. Do not add mutable deadline setters to the domain
objects.

### 3.3 — What should happen to an existing itinerary and delivery state?

**Question:** When a routed cargo's deadline changes, should its itinerary be
cleared, retained, or recomputed?

Although the UI initially exposes the feature only for unrouted cargo, the
application operation should have deterministic domain behavior if invoked for
a routed cargo. The existing `changeDestination(...)` behavior preserves the
assigned itinerary and lets `Cargo.specifyNewRoute(...)` recalculate whether
that itinerary still satisfies the new specification.

The core application test should deliberately invoke the operation after:

1. booking a cargo;
2. requesting route candidates;
3. assigning an itinerary;
4. changing its destination;
5. changing its deadline.

This sequence verifies that the feature uses the aggregate correctly rather
than assuming the cargo always has an empty itinerary.

**Recommendation:** Preserve the itinerary. Let the domain model recompute
routing and delivery-derived state. Assert all unaffected fields explicitly in
`BookingServiceTest`.

**Resolution:**

Retain the existing itinerary. Do not clear, replace, or reroute it as part of
the deadline change. `Cargo.specifyNewRoute(...)` recalculates the delivery
snapshot and routing status against the replacement specification. In the
established sequential application test, the assigned itinerary remains
unchanged and the cargo remains `MISROUTED` after the deadline changes.

### 3.4 — What type crosses the facade boundary?

**Question:** Should the booking facade accept a `Date`, a formatted string, or
a newly introduced request DTO?

The existing facade already uses `java.util.Date` for
`bookNewCargo(...)`. Introducing another representation for this one operation
would create unnecessary conversion code and depart from the historical
application style.

Proposed facade shape:

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```
````

</details>


---

<sub>54s</sub>

### `view`

**view the file at C:\Users\edburns\AppData\Local\Temp\1789060909364-copilot-tool-output-15204-76413860-5a85-44d2-b81f-ccd2db90bc66.txt.**

C:\Users\edburns\AppData\Local\Temp\1789060909364-copilot-tool-output-15204-76413860-5a85-44d2-b81f-ccd2db90bc66.txt (lines 261-520)

<details>
<summary>195 lines</summary>

````
The implementation converts only the identifier:

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

**Recommendation:** Use `String` for the tracking ID and `java.util.Date` for
the deadline. Do not expose `TrackingId`, `Cargo`, or `RouteSpecification` to
the JSF layer and do not introduce a new DTO solely for this command.

**Resolution:**

Add `void changeDeadline(String trackingId, Date arrivalDeadline)` to
`BookingServiceFacade`. `DefaultBookingServiceFacade` converts the string to
`new TrackingId(trackingId)` and passes the same `Date` to
`BookingService.changeDeadline(...)`. No new command DTO or formatted-string
service parameter is introduced.

### 3.5 — How is the DTO's formatted deadline converted for editing?

**Question:** `CargoRoute` exposes its deadline as formatted strings, while
`p:datePicker` binds naturally to `java.util.Date`. How should the backing bean
initialize the editor?

At the starting commit:

- `CargoRoute.getArrivalDeadline()` returns
  `MM/dd/yyyy hh:mm a z`.
- `CargoRoute.getArrivalDeadlineDate()` returns only the date component.
- The table displays `getArrivalDeadlineDate()`.

Options:

| Option | Approach | Trade-off |
|--------|----------|-----------|
| A | Parse `cargo.getArrivalDeadlineDate()` with `MM/dd/yyyy` | Small, localized change; preserves the existing DTO contract. |
| B | Add a `Date` property to `CargoRoute` | Cleaner typing, but broadens a DTO used throughout the application. |
| C | Reload the domain object in the backing bean | Violates the facade boundary. |

The formatter/parser must be created per operation or per view bean; do not add
a shared mutable `SimpleDateFormat`.

**Recommendation:** Option A. Load `CargoRoute` through
`BookingServiceFacade.loadCargoForRouting(trackingId)` and parse
`cargo.getArrivalDeadlineDate()` using `new SimpleDateFormat("MM/dd/yyyy")`.
Surface an explicit failure if the existing DTO value cannot be parsed; do not
silently submit a null date.

**Resolution:**

Use Option A and keep date conversion inside the view-scoped editor bean. The
existing implementation loads the `CargoRoute`, creates
`new SimpleDateFormat("MM/dd/yyyy")`, and parses the leading date portion of
`cargo.getArrivalDeadline()`. Because that value begins with `MM/dd/yyyy`,
`SimpleDateFormat.parse(...)` obtains the same date that
`getArrivalDeadlineDate()` displays. A per-load formatter is used, so no shared
mutable formatter is added.

### 3.6 — Which JSF bean scopes and interaction pattern should be used?

**Question:** Should deadline editing introduce a new navigation page, use an
inline editor, or mirror the existing Change Destination dynamic-dialog
pattern?

The baseline already contains:

- `ChangeDestination`, a CDI `@Named` and JSF `@ViewScoped` editor bean;
- `ChangeDestinationDialog`, a session-scoped JSF managed bean that opens and
  closes a PrimeFaces dynamic dialog;
- `changeDestination.xhtml`, a dialog view;
- a `dialogReturn` Ajax listener that refreshes `tableNotRouted`.

Using the same pattern minimizes changes and provides a consistent user
experience.

Proposed bean names:

```text
changeArrivalDeadlineDate
changeArrivalDeadlineDateDialog
```

**Recommendation:** Add a serializable CDI `@Named @ViewScoped`
`ChangeArrivalDeadlineDate` editor and a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped`
launcher. Mirror the existing destination-dialog lifecycle rather than
introducing a new navigation or inline-edit framework.

**Resolution:**

Mirror the existing Change Destination interaction. Implement
`ChangeArrivalDeadlineDate` as a serializable CDI `@Named @ViewScoped` bean and
`ChangeArrivalDeadlineDateDialog` as a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped` bean.
Use a PrimeFaces dynamic dialog rather than navigation to a full page or inline
cell editing.

### 3.7 — What is the dynamic-dialog contract?

**Question:** What path, request parameters, dimensions, and close result should
the PrimeFaces dialog use?

The launcher needs one parameter, `trackingId`, supplied as a
`Map<String, List<String>>`. The dialog metadata binds the parameter and invokes
the editor bean's `load()` action.

Proposed launcher contract:

```java
PrimeFaces.current().dialog().openDynamic(
        "/admin/dialogs/changeArrivalDeadlineDate.xhtml",
        options,
        params);
```

Required options:

| Option | Value |
|--------|-------|
| `modal` | `true` |
| `draggable` | `true` |
| `resizable` | `false` |
| `contentWidth` | `410` |
| `contentHeight` | `280` |

Required completion behavior:

- successful update: `closeDynamic("DONE")`;
- cancel: `closeDynamic("")`;
- caller listens for `dialogReturn` and updates `tableNotRouted`.

Because Open Liberty uses MyFaces, `<f:metadata>` must be a direct child of the
view root, before `<h:head>` and `<h:body>`. It must not be nested inside
`<h:body>`.

**Recommendation:** Use the contract above and preserve the metadata placement
required by the prepared baseline.

**Resolution:**

Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with a single
`trackingId` request parameter and these options: modal and draggable are
`true`, resizable is `false`, content width is `410`, and content height is
`280`. Successful submission closes with `"DONE"`; cancellation closes with
the empty string. The caller handles `dialogReturn` and updates
`tableNotRouted`. Place the dialog's `<f:metadata>` directly under the root
`<html>` element, before `<h:head>` and `<h:body>`, so the known MyFaces
`UIViewRoot` requirement is satisfied.

### 3.8 — What date validation is required?

**Question:** Must the new deadline be non-null, in the future, after the
current date, or after itinerary completion?

The requested feature is an administrative correction to an existing arrival
deadline. No new domain policy about future dates is part of the request.
Inventing such a rule could reject dates accepted by existing cargo booking or
`RouteSpecification` behavior.

The UI must nevertheless prevent a null submission because the operation
requires a concrete replacement deadline.

**Recommendation:** Require a date value in the JSF form and display a normal
Faces validation message when it is absent. Do not add a new minimum-date,
future-date, or itinerary-date business rule. Continue to rely on the existing
domain model for its established invariants.

**Resolution:**

Require a non-null date selection, but add no new chronological business rule.
In particular, do not require the replacement deadline to be after today,
after the old deadline, or after every itinerary leg. Pass the selected
`java.util.Date` to the existing domain construction path and let the current
`RouteSpecification` invariants apply.

### 3.9 — How will the feature be tested on the prepared historical baseline?

**Question:** Which automated and runtime tests are mandatory, given that the
historical JUnit/Arquillian suite is configured for a remote Payara 4
container, while the prepared production baseline runs on JDK 17/Open Liberty?

The starting POM deliberately leaves `skipTests=true`. The Open Liberty profile
builds and compiles all test sources but does not provide a Liberty Arquillian
adapter. Modernizing the entire integration-test runtime is outside this
feature's scope.

The feature still needs layered evidence:

1. Extend `BookingServiceTest` with the domain/application assertions that
   specify the deadline mutation.
2. Ensure all test sources compile as part of
   `./mvnw clean package -Popenliberty`.
3. Add focused JUnit tests for facade and backing-bean delegation where they
   can run without a container, using hand-written fakes rather than adding a
   mocking framework.
4. Perform mandatory end-to-end verification against the running Open Liberty
   application.
5. Preserve the existing Payara Arquillian test path; do not delete, disable,
   or rewrite it to manufacture a passing result.

**Spike needed:** Before Issue 1 implementation, run the starting commit's
standard Open Liberty package command and record whether tests are compiled but
skipped. Confirm the new `BookingServiceTest` method can be added without
expanding the runtime modernization scope.

**Recommendation:** Treat the JDK 17/Open Liberty build plus HTTP/UI acceptance
as the mandatory executable gate. Keep the historical Arquillian test as a
precise application-layer specification and run it only when its documented
Payara environment is available.

**Resolution:**

Extend the existing sequential Arquillian `BookingServiceTest` with
`testChangeDeadline()` after `testChangeDestination()`. The test changes the
deadline by one month, reloads the cargo through JPA, and asserts the complete
set of preserved and recalculated domain state described above. The prepared
Open Liberty build compiles this test but retains the historical default
`skipTests=true`; executing that Arquillian suite still requires its documented
remote Payara environment. Therefore the mandatory executable gates are the
JDK 17 Open Liberty package/start command, direct HTTP checks, and the complete
`DEF789` browser acceptance flow. No Arquillian-runtime modernization or new
mocking dependency is part of this feature.

---

## Phase 4 — Implementation (five serial issues)

Implement these issues in order. Each issue should be a separate commit. Do not
start an issue until the previous issue's gating criteria are satisfied.

### 4.1 — Issue 1: Add the application-layer deadline change operation

**What to build**

Add the core use case to the application layer. This issue must contain no JSF
or PrimeFaces changes.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`
- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

**Required API**

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

**Required implementation behavior**

1. Load the cargo using `cargoRepository.find(trackingId)`.
2. Obtain the current destination from
   `cargo.getRouteSpecification().getDestination()`.
3. Construct a replacement `RouteSpecification` from:
   - `cargo.getOrigin()`;
   - the current destination;
   - the new deadline.
````

</details>


---

<sub>54s</sub>

### `view`

**view the file at C:\Users\edburns\AppData\Local\Temp\1789060909364-copilot-tool-output-15204-76413860-5a85-44d2-b81f-ccd2db90bc66.txt.**

C:\Users\edburns\AppData\Local\Temp\1789060909364-copilot-tool-output-15204-76413860-5a85-44d2-b81f-ccd2db90bc66.txt (lines 521--1)

<details>
<summary>285 lines</summary>

````
4. Apply it using `cargo.specifyNewRoute(routeSpecification)`.
5. Persist using `cargoRepository.store(cargo)`.
6. Log the tracking ID and new deadline at `Level.INFO`, following the style of
   `changeDestination(...)`.

Do not:

- add a setter to `Cargo` or `RouteSpecification`;
- modify the origin or destination;
- clear or replace the itinerary directly;
- update persistence entities behind the aggregate's back.

**Tests to write first**

Append a sequential `testChangeDeadline()` case to `BookingServiceTest` after
`testChangeDestination()`. Build a new deadline one month after the test's
original `deadline`, invoke the service, reload the cargo with
`Cargo.findByTrackingId`, and assert:

- origin remains Chicago;
- destination remains Helsinki;
- stored deadline is the same calendar day as the requested new deadline;
- assigned itinerary remains unchanged;
- transport status remains `NOT_RECEIVED`;
- last known location remains `Location.UNKNOWN`;
- current voyage remains `Voyage.NONE`;
- cargo is not marked misdirected;
- estimated time of arrival is `Delivery.ETA_UNKOWN`;
- next expected activity is `Delivery.NO_ACTIVITY`;
- cargo is not unloaded at destination;
- routing status reflects the domain model's recalculation and remains
  `MISROUTED` for the established test sequence.

**Gating criteria**

- The test source compiles.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- No web, facade, REST, Liberty, or persistence configuration files change in
  this issue.

### 4.2 — Issue 2: Expose deadline changes through the booking facade

**What to build**

Expose the use case to presentation clients without leaking domain identifier
types into the web layer.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`

**Optional focused test file**

- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`

**Required API**

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```

**Required implementation**

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

The facade must not:

- load and mutate `Cargo` itself;
- call `CargoRepository.store(...)`;
- parse a formatted date;
- introduce JSF or PrimeFaces types.

**Tests**

Where a container-free test is added, use a hand-written `BookingService` fake
or spy and prove that:

- the same `Date` object/value reaches the application service;
- the tracking-ID string is converted to an equivalent `TrackingId`;
- the facade delegates exactly once;
- no repository work is duplicated in the facade.

Do not add Mockito or another dependency solely for this test.

**Gating criteria**

- Existing facade consumers still compile.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- The application-layer test added in Issue 1 remains unchanged and compiling.

### 4.3 — Issue 3: Implement the deadline editor backing model

**What to build**

Add the view-scoped backing bean that loads a cargo's current deadline and
submits a replacement deadline through the booking facade. Do not add the
dialog launcher or XHTML in this issue.

**File to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`

**Required bean shape**

```java
@Named
@ViewScoped
public class ChangeArrivalDeadlineDate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String trackingId;
    private CargoRoute cargo;
    private Date arrivalDeadlineDate;

    @Inject
    private BookingServiceFacade bookingServiceFacade;
}
```

Required properties and methods:

- `getTrackingId()` / `setTrackingId(String)`
- `getCargo()`
- `getArrivalDeadlineDate()` / `setArrivalDeadlineDate(Date)`
- `load()`
- `changeArrivalDeadline()`

**Load behavior**

1. Call `bookingServiceFacade.loadCargoForRouting(trackingId)`.
2. Store the returned `CargoRoute`.
3. Parse `cargo.getArrivalDeadlineDate()` using `MM/dd/yyyy`.
4. Store the resulting `Date` in `arrivalDeadlineDate`.
5. Do not query a repository or domain object directly.
6. Do not ignore a parsing failure or merely print its stack trace. Surface a
   clear application/view error consistent with existing JSF behavior.

**Submit behavior**

1. Refuse a null date through JSF validation or explicit bean validation.
2. Call
   `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`.
3. Close the dynamic dialog with:

   ```java
   PrimeFaces.current().dialog().closeDynamic("DONE");
   ```

4. Do not close the dialog if the facade call fails.

**Tests to write**

Add a container-free JUnit test if practical, using a hand-written fake facade,
that proves:

- `load()` requests the correct tracking ID;
- `load()` converts an `MM/dd/yyyy` DTO date into the editable `Date`;
- `changeArrivalDeadline()` delegates the selected date and tracking ID;
- a malformed DTO deadline is surfaced rather than converted to null;
- a null selected date is rejected.

Do not add a mocking framework solely for these tests.

**Gating criteria**

- The bean is serializable and uses the established CDI/JSF annotations.
- The bean references only facade DTOs, not domain model classes.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.

### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog

**What to build**

Add the session-scoped dialog launcher and the dynamic dialog view. The dialog
must work when addressed directly with a `trackingId` query parameter, but it
is not yet linked from the dashboard in this issue.

**Files to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`
- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`

**Launcher requirements**

Use:

```java
@ManagedBean(name = "changeArrivalDeadlineDateDialog")
@SessionScoped
```

Implement:

- `showDialog(String trackingId)`
- `handleReturn(SelectEvent event)`
- `cancel()`

`showDialog(...)` must:

- set the options documented in Question 3.7;
- pass `trackingId` as a dynamic-dialog request parameter;
- open `/admin/dialogs/changeArrivalDeadlineDate.xhtml`.

`cancel()` must close the dialog without invoking the facade.

**XHTML requirements**

The page title must be:

```xhtml
<title>Change Deadline</title>
```

Place metadata directly beneath the root `<html>` element and before
`<h:head>`:

```xhtml
<f:metadata>
    <f:viewParam name="trackingId"
                 value="#{changeArrivalDeadlineDate.trackingId}"/>
    <f:viewAction action="#{changeArrivalDeadlineDate.load}"/>
</f:metadata>
```

The form must display:

- `Origin:` and `changeArrivalDeadlineDate.cargo.originName`;
- `Destination:` and
  `changeArrivalDeadlineDate.cargo.finalDestinationName`;
- `Deadline:` and a `p:datePicker` bound to
  `changeArrivalDeadlineDate.arrivalDeadlineDate`;
- **Cancel**, invoking
  `changeArrivalDeadlineDateDialog.cancel()`;
- **Update**, invoking
  `changeArrivalDeadlineDate.changeArrivalDeadline()`.

The date picker must require a value. The Update action must reload or refresh
the calling Administration view after a successful dialog close, following the
existing destination-dialog behavior.

**Runtime tests**

With the application running, request:

```text
http://localhost:8080/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789
```

Verify:

- HTTP 200;
- title is **Change Deadline**;
- origin and destination render;
- the existing deadline is selected;
- no `TagException`, `Parent UIComponent`, `FacesException`, or server error is
  present;
- Cancel does not change the persisted deadline;
- Update changes the deadline.

**Gating criteria**

- `./mvnw clean package -Popenliberty liberty:run` succeeds on JDK 17.
- Direct dialog loading and both actions work.
- Destination editing continues to work.
- Stop Liberty cleanly before completing the issue.

### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard

**What to build**

Replace the plain deadline text in the Not Routed Cargo table with the
PrimeFaces command-link affordance that opens the completed dialog and refreshes
the table after return.

**File to modify**

- `src/main/webapp/admin/tables/listNotRouted.xhtml`

**Required UI shape**

Within the existing Deadline column, add a `p:commandLink` that:

- calls
  `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;
- retains the displayed
  `cargoNotRouted.arrivalDeadlineDate`;
- adds the existing Font Awesome edit icon style;
- uses a stable component ID such as `arrivalDeadlineToUpdate`;
- listens for `dialogReturn`;
- invokes
  `changeArrivalDeadlineDateDialog.handleReturn`;
- updates `tableNotRouted`;
- provides the tooltip:
  `Click to change cargo arrival deadline date.`

Follow the adjacent Destination column's established structure and styling. Do
not alter tracking-ID routing or destination editing.

**End-to-end acceptance test**

1. Start from a clean build on JDK 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Confirm the home page returns HTTP 200.
3. Open Administration and locate `DEF789`.
4. Record the original deadline.
5. Confirm the deadline now has an edit icon and tooltip.
6. Open the deadline dialog.
7. Confirm origin and destination identify the same cargo.
8. Choose a visibly different date.
9. Press **Update**.
10. Confirm the dialog closes and the Not Routed Cargo table refreshes.
11. Confirm the table shows the selected date.
12. Reload the browser and confirm the selected date remains.
13. Reopen the dialog and confirm the editor initializes to the changed date.
14. Press **Cancel** and confirm no additional change occurs.
15. Verify the Destination edit dialog still opens.
16. Verify selecting `DEF789` for routing still loads without an error page.

**Log acceptance**

The final run must contain none of:

- `<f:metadata> Parent UIComponent`;
- `TagException`;
- `VerifyError`;
- `FacesException`;
- `CWWKZ0002E` or `CWWKZ0003E`;
- recurring batch authorization failures;
- new FFDC files attributable to this feature.

Transient JMS activation-order warnings are acceptable only if all message
endpoints subsequently activate, as established by the prepared baseline.

**Final regression and scope checks**

- `./mvnw clean package -Popenliberty` succeeds.
- The existing test sources and the new deadline test compile.
- No Java EE namespace migration occurred.
- No Open Liberty, Derby, Jackson, JSF metadata, batch authorization, or REST
  compatibility fix from the starting commit was reverted.
- The feature affects only the intended application, facade, web, dialog,
  table, and test surfaces.
- Stop Liberty cleanly.

---

## Phase 5 — Documentation and implementation handoff

- Update `README.md` only if user-facing Administration capabilities are
  enumerated there; add one concise sentence that administrators can change an
  unrouted cargo's arrival deadline.
- Record the exact JDK 17 run command in the final issue or pull-request
  description:

  ```bash
  ./mvnw clean package -Popenliberty liberty:run
  ```

- Include `DEF789` and the before/after deadline values in the acceptance
  evidence.
- State explicitly that data is in-memory and resets when the application is
  rebuilt/restarted.

---

## Cross-cutting concerns

| Concern | Required handling |
|---------|--------------------|
| Domain-driven design | Mutate the aggregate through `Cargo.specifyNewRoute(...)`; do not bypass it with persistence-level field updates. |
| Layering | Web bean → booking facade → booking service → cargo repository. |
| Date handling | Use `java.util.Date` at service/facade boundaries and `MM/dd/yyyy` for the date-only editor representation. |
| Time zones | Acceptance compares the calendar date displayed by the application; do not introduce a new timezone policy in this feature. |
| Error handling | Do not silently swallow parse, lookup, validation, or persistence failures. A failed update must not look successful. |
| JSF compatibility | Keep `<f:metadata>` at view-root scope for MyFaces. |
| Bean lifecycle | Editor is CDI `@ViewScoped`; dynamic-dialog launcher mirrors the existing session-scoped JSF managed bean. |
| Accessibility | Preserve visible labels; the date editor must have an associated label and validation feedback. |
| Backward compatibility | Existing destination editing, routing, tracking, REST, messaging, batch, and startup behavior must remain intact. |
| Test discipline | Add tests before production code where practical; every issue must preserve all prior gates. |
| Experiment integrity | Implement from this specification starting at `9b9f311b2a3a2854bdac947593950d9edb6bca7d`; do not cherry-pick or inspect feature-bearing commits. |
````

</details>


---

<sub>54s</sub>

### `powershell`

**Count exact plan sections and tasks**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; $plan = git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md'; if($LASTEXITCODE -ne 0){throw 'Unable to read plan.'}; $headings=@($plan|Where-Object{$_ -match '^#{2,4} '}); $questions=@($headings|Where-Object{$_ -match '^### Q'}); $tasks=@(); $inImplementation=$false; foreach($line in $plan){ if($line -eq '## Phase 4 — Implementation (five serial issues)'){$inImplementation=$true;continue}; if($inImplementation -and $line -match '^## '){break}; if($inImplementation -and $line -match '^### '){$tasks+=$line} }; [pscustomobject]@{questionsHeadingCount=@($plan|Where-Object{$_ -eq '## Phase 3 — Ignorance reduction: questions to answer before writing code'}).Count;implementationHeadingCount=@($plan|Where-Object{$_ -eq '## Phase 4 — Implementation (five serial issues)'}).Count;questionHeadings=$questions;directTasks=$tasks;directTaskCount=$tasks.Count}|ConvertTo-Json -Depth 4",
  "description": "Count exact plan sections and tasks",
  "initial_wait": 30,
  "mode": "sync"
}
```

</details>

<details>
<summary>14 lines</summary>

```
{
  "questionsHeadingCount": 1,
  "implementationHeadingCount": 1,
  "questionHeadings": [],
  "directTasks": [
    "### 4.1 — Issue 1: Add the application-layer deadline change operation",
    "### 4.2 — Issue 2: Expose deadline changes through the booking facade",
    "### 4.3 — Issue 3: Implement the deadline editor backing model",
    "### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog",
    "### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard"
  ],
  "directTaskCount": 5
}
<shellId: 4 completed with exit code 0>
```

</details>


---

<sub>1m 8s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\validate-stage20-drafts.ps1.**

C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\validate-stage20-drafts.ps1

<details>
<summary>60 lines</summary>

```
# shepherd-task-version: 1.0.2
<#
.SYNOPSIS
    Validates persisted stage-20 issue bodies before GitHub mutation.
#>

[CmdletBinding()]
param(
    [Parameter(Mandatory)]
    [string]$BodyDirectory,

    [Parameter(Mandatory)]
    [ValidateRange(1, [int]::MaxValue)]
    [int]$ExpectedCount,

    [Parameter(Mandatory)]
    [ValidateSet('off', 'campaign')]
    [string]$LessonPropagation
)

Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'

if (-not (Test-Path -LiteralPath $BodyDirectory -PathType Container)) {
    throw "Stage-20 body directory does not exist: $BodyDirectory"
}

$bodyFiles = @(
    Get-ChildItem -LiteralPath $BodyDirectory -Filter '*-body.md' -File |
        Where-Object { $_.Name -notlike '*-observed-body.md' } |
        Sort-Object Name
)
if ($bodyFiles.Count -ne $ExpectedCount) {
    throw "Expected $ExpectedCount persisted stage-20 body files; found $($bodyFiles.Count)."
}

$requiredHeadings = @(
    '## Campaign context and required reading',
    '## Branch and execution order',
    '## Implement',
    '## Completion gates',
    '## Out of scope'
)

foreach ($bodyFile in $bodyFiles) {
    $text = [System.IO.File]::ReadAllText($bodyFile.FullName)
    $lines = [System.IO.File]::ReadAllLines($bodyFile.FullName)
    if ([string]::IsNullOrWhiteSpace($text) -or $text -notmatch "`r?`n" -or $lines.Count -le 1) {
        throw "Persisted issue body must contain physical Markdown lines: $($bodyFile.FullName)"
    }

    $firstNonblank = $lines | Where-Object { -not [string]::IsNullOrWhiteSpace($_) } | Select-Object -First 1
    if ($firstNonblank -notmatch '^##\s+\S') {
        throw "Persisted issue body must begin with a level-two heading: $($bodyFile.FullName)"
    }

    foreach ($heading in $requiredHeadings) {
        if ($lines -cnotcontains $heading) {
            throw "Persisted issue body is missing the physical heading '$heading': $($bodyFile.FullName)"
        }
    }

    $hasCampaignLessons = $lines -ccontains '## Campaign lessons (REQUIRED)'
    if ($LessonPropagation -eq 'campaign' -and -not $hasCampaignLessons) {
        throw "Treatment issue body is missing its campaign-lessons heading: $($bodyFile.FullName)"
    }
    if ($LessonPropagation -eq 'off' -and $hasCampaignLessons) {
        throw "Control issue body unexpectedly contains a campaign-lessons heading: $($bodyFile.FullName)"
    }
}

$bodyFiles
```

</details>


---

<sub>1m 8s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-github-issue-body.ps1.**

C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\verify-github-issue-body.ps1 (lines 1-220)

<details>
<summary>166 lines</summary>

```
# shepherd-task-version: 1.0.2
<#
.SYNOPSIS
    Fetches a GitHub issue through REST and verifies its body against a file.
#>

[CmdletBinding()]
param(
    [Parameter(Mandatory)]
    [ValidatePattern('^[A-Za-z0-9_.-]+/[A-Za-z0-9_.-]+$')]
    [string]$Repository,

    [Parameter(Mandatory)]
    [ValidateRange(1, [int]::MaxValue)]
    [int]$IssueNumber,

    [Parameter(Mandatory)]
    [string]$ExpectedBodyPath,

    [ValidateRange(1, 100)]
    [int]$MaxAttempts = 6,

    [ValidateRange(0, 300)]
    [int]$DelaySeconds = 5,

    [string]$DiagnosticPath,

    [string]$GitHubCli = 'gh'
)

Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'
$PSNativeCommandUseErrorActionPreference = $false

function ConvertTo-NormalizedLineEndings {
    param([AllowEmptyString()][string]$Text)
    return $Text -replace "`r`n|`r", "`n"
}

function Test-EquivalentBody {
    param(
        [AllowEmptyString()][string]$Actual,
        [AllowEmptyString()][string]$Expected
    )

    if ($Actual -ceq $Expected) {
        return $true
    }
    if ($Actual.EndsWith("`n") -and $Actual.Substring(0, $Actual.Length - 1) -ceq $Expected) {
        return $true
    }
    if ($Expected.EndsWith("`n") -and $Expected.Substring(0, $Expected.Length - 1) -ceq $Actual) {
        return $true
    }
    return $false
}

function Get-Sha256 {
    param([AllowEmptyString()][string]$Text)

    $bytes = [System.Text.UTF8Encoding]::new($false).GetBytes($Text)
    return [Convert]::ToHexString([System.Security.Cryptography.SHA256]::HashData($bytes)).ToLowerInvariant()
}

function Get-FirstDifference {
    param(
        [AllowEmptyString()][string]$Actual,
        [AllowEmptyString()][string]$Expected
    )

    $limit = [Math]::Min($Actual.Length, $Expected.Length)
    $offset = 0
    while ($offset -lt $limit -and $Actual[$offset] -ceq $Expected[$offset]) {
        $offset++
    }
    if ($offset -eq $limit -and $Actual.Length -eq $Expected.Length) {
        return $null
    }

    $prefix = $Expected.Substring(0, [Math]::Min($offset, $Expected.Length))
    $line = ([regex]::Matches($prefix, "`n").Count) + 1
    $lastNewline = $prefix.LastIndexOf("`n", [StringComparison]::Ordinal)
    $column = if ($lastNewline -lt 0) { $offset + 1 } else { $offset - $lastNewline }
    return [ordered]@{
        offset = $offset
        line = $line
        column = $column
    }
}

function Test-TerminalGitHubFailure {
    param([string]$Message)
    return $Message -match '(?i)(HTTP\s+(401|403)|authentication|not authorized|resource not accessible)'
}

function Write-Diagnostic {
    param(
        [string]$Reason,
        [int]$Attempts,
        [AllowEmptyString()][string]$Actual,
        [AllowEmptyString()][string]$Expected
    )

    if ([string]::IsNullOrWhiteSpace($DiagnosticPath)) {
        return
    }

    $parent = Split-Path -Parent $DiagnosticPath
    if (-not [string]::IsNullOrWhiteSpace($parent) -and
        -not (Test-Path -LiteralPath $parent -PathType Container)) {
        New-Item -ItemType Directory -Path $parent | Out-Null
    }

    $diagnostic = [ordered]@{
        schemaVersion = 1
        repository = $Repository
        issueNumber = $IssueNumber
        endpoint = "repos/$Repository/issues/$IssueNumber"
        attempts = $Attempts
        observedAt = (Get-Date).ToUniversalTime().ToString('o')
        reason = $Reason
        expectedLength = $Expected.Length
        actualLength = $Actual.Length
        expectedSha256 = Get-Sha256 $Expected
        actualSha256 = Get-Sha256 $Actual
        firstDifference = Get-FirstDifference -Actual $Actual -Expected $Expected
    }
    $diagnostic | ConvertTo-Json -Depth 4 |
        Set-Content -LiteralPath $DiagnosticPath -Encoding utf8NoBOM
}

if (-not (Test-Path -LiteralPath $ExpectedBodyPath -PathType Leaf)) {
    throw "Expected issue body file not found: $ExpectedBodyPath"
}

$expected = ConvertTo-NormalizedLineEndings (
    Get-Content -LiteralPath $ExpectedBodyPath -Raw
)
$lastReason = ''
$lastActual = ''
$previousConsoleOutputEncoding = [Console]::OutputEncoding
$previousOutputEncoding = $OutputEncoding
$utf8Encoding = [System.Text.UTF8Encoding]::new($false)

try {
    [Console]::OutputEncoding = $utf8Encoding
    $OutputEncoding = $utf8Encoding

    for ($attempt = 1; $attempt -le $MaxAttempts; $attempt++) {
        $output = (& $GitHubCli api "repos/$Repository/issues/$IssueNumber" 2>&1 | Out-String).Trim()
        $exitCode = $LASTEXITCODE
        if ($exitCode -ne 0) {
            $lastReason = "GitHub REST request failed with exit code $exitCode."
            if (Test-TerminalGitHubFailure $output) {
                Write-Diagnostic -Reason $lastReason -Attempts $attempt -Actual '' -Expected $expected
                throw "Unable to fetch issue #$IssueNumber from ${Repository}: $output"
            }
        }
        else {
            try {
                $issue = $output | ConvertFrom-Json
                $lastActual = ConvertTo-NormalizedLineEndings ([string]$issue.body)
                if (Test-EquivalentBody -Actual $lastActual -Expected $expected) {
                    return $issue
                }
                $lastReason = 'GitHub issue body differs from the persisted draft.'
            }
            catch {
                $lastReason = "GitHub REST response was invalid JSON: $($_.Exception.Message)"
            }
        }

        if ($attempt -lt $MaxAttempts) {
            Write-Warning "$lastReason Retrying issue #$IssueNumber body verification ($attempt/$MaxAttempts)."
            if ($DelaySeconds -gt 0) {
                Start-Sleep -Seconds $DelaySeconds
            }
        }
    }

    Write-Diagnostic -Reason $lastReason -Attempts $MaxAttempts -Actual $lastActual -Expected $expected
    $diagnosticSuffix = if ([string]::IsNullOrWhiteSpace($DiagnosticPath)) {
        ''
    }
    else {
        " Diagnostic: $DiagnosticPath"
    }
    throw "Issue #$IssueNumber body verification failed after $MaxAttempts attempts. $lastReason$diagnosticSuffix"
}
finally {
    $OutputEncoding = $previousOutputEncoding
    [Console]::OutputEncoding = $previousConsoleOutputEncoding
}
```

</details>


---

<sub>1m 9s</sub>

### `powershell`

**Parse complete resolution blocks**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; $plan=@(git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md'); if($LASTEXITCODE -ne 0){throw 'Unable to read plan.'}; $start=[Array]::IndexOf($plan,'## Phase 3 — Ignorance reduction: questions to answer before writing code'); $end=[Array]::IndexOf($plan,'## Phase 4 — Implementation (five serial issues)'); if($start -lt 0 -or $end -le $start){throw 'Invalid questions section bounds.'}; $section=$plan[($start+1)..($end-1)]; $starts=@(); for($i=0;$i -lt $section.Count;$i++){if($section[$i] -match '^### 3\\.\\d+ '){$starts+=$i}}; $parsed=@(); foreach($j in 0..($starts.Count-1)){ $s=$starts[$j]; $e=if($j+1 -lt $starts.Count){$starts[$j+1]-1}else{$section.Count-1}; $block=@($section[$s..$e]); $r=[Array]::IndexOf($block,'**Resolution:**'); $resolution=if($r -ge 0){(@($block[($r+1)..($block.Count-1)]) -join \"`n\").Trim()}else{$null}; $parsed += [pscustomobject]@{heading=$block[0];resolution=$resolution} }; $parsed|ConvertTo-Json -Depth 4",
  "description": "Parse complete resolution blocks",
  "initial_wait": 30,
  "mode": "sync"
}
```

</details>

<details>
<summary>39 lines</summary>

```
[
  {
    "heading": "### 3.1 — Which cargos expose the edit operation?",
    "resolution": "Select Option A. Expose the edit affordance only in\n`src/main/webapp/admin/tables/listNotRouted.xhtml`. The application and facade\noperations remain generally callable for any cargo that can be found by\ntracking ID; they do not encode knowledge of dashboard table membership."
  },
  {
    "heading": "### 3.2 — What is the exact domain mutation?",
    "resolution": "Use the same aggregate-update pattern as `changeDestination(...)`. Add\n`BookingService.changeDeadline(TrackingId, Date)` and implement it by loading\nthe cargo, constructing a new `RouteSpecification` from the existing origin,\nexisting destination, and supplied deadline, calling\n`cargo.specifyNewRoute(...)`, and storing the cargo through\n`cargoRepository.store(...)`. Do not add mutable deadline setters to the domain\nobjects."
  },
  {
    "heading": "### 3.3 — What should happen to an existing itinerary and delivery state?",
    "resolution": "Retain the existing itinerary. Do not clear, replace, or reroute it as part of\nthe deadline change. `Cargo.specifyNewRoute(...)` recalculates the delivery\nsnapshot and routing status against the replacement specification. In the\nestablished sequential application test, the assigned itinerary remains\nunchanged and the cargo remains `MISROUTED` after the deadline changes."
  },
  {
    "heading": "### 3.4 — What type crosses the facade boundary?",
    "resolution": "Add `void changeDeadline(String trackingId, Date arrivalDeadline)` to\n`BookingServiceFacade`. `DefaultBookingServiceFacade` converts the string to\n`new TrackingId(trackingId)` and passes the same `Date` to\n`BookingService.changeDeadline(...)`. No new command DTO or formatted-string\nservice parameter is introduced."
  },
  {
    "heading": "### 3.5 — How is the DTO's formatted deadline converted for editing?",
    "resolution": "Use Option A and keep date conversion inside the view-scoped editor bean. The\nexisting implementation loads the `CargoRoute`, creates\n`new SimpleDateFormat(\"MM/dd/yyyy\")`, and parses the leading date portion of\n`cargo.getArrivalDeadline()`. Because that value begins with `MM/dd/yyyy`,\n`SimpleDateFormat.parse(...)` obtains the same date that\n`getArrivalDeadlineDate()` displays. A per-load formatter is used, so no shared\nmutable formatter is added."
  },
  {
    "heading": "### 3.6 — Which JSF bean scopes and interaction pattern should be used?",
    "resolution": "Mirror the existing Change Destination interaction. Implement\n`ChangeArrivalDeadlineDate` as a serializable CDI `@Named @ViewScoped` bean and\n`ChangeArrivalDeadlineDateDialog` as a serializable\n`@ManagedBean(name = \"changeArrivalDeadlineDateDialog\") @SessionScoped` bean.\nUse a PrimeFaces dynamic dialog rather than navigation to a full page or inline\ncell editing."
  },
  {
    "heading": "### 3.7 — What is the dynamic-dialog contract?",
    "resolution": "Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with a single\n`trackingId` request parameter and these options: modal and draggable are\n`true`, resizable is `false`, content width is `410`, and content height is\n`280`. Successful submission closes with `\"DONE\"`; cancellation closes with\nthe empty string. The caller handles `dialogReturn` and updates\n`tableNotRouted`. Place the dialog's `<f:metadata>` directly under the root\n`<html>` element, before `<h:head>` and `<h:body>`, so the known MyFaces\n`UIViewRoot` requirement is satisfied."
  },
  {
    "heading": "### 3.8 — What date validation is required?",
    "resolution": "Require a non-null date selection, but add no new chronological business rule.\nIn particular, do not require the replacement deadline to be after today,\nafter the old deadline, or after every itinerary leg. Pass the selected\n`java.util.Date` to the existing domain construction path and let the current\n`RouteSpecification` invariants apply."
  },
  {
    "heading": "### 3.9 — How will the feature be tested on the prepared historical baseline?",
    "resolution": "Extend the existing sequential Arquillian `BookingServiceTest` with\n`testChangeDeadline()` after `testChangeDestination()`. The test changes the\ndeadline by one month, reloads the cargo through JPA, and asserts the complete\nset of preserved and recalculated domain state described above. The prepared\nOpen Liberty build compiles this test but retains the historical default\n`skipTests=true`; executing that Arquillian suite still requires its documented\nremote Payara environment. Therefore the mandatory executable gates are the\nJDK 17 Open Liberty package/start command, direct HTTP checks, and the complete\n`DEF789` browser acceptance flow. No Arquillian-runtime modernization or new\nmocking dependency is part of this feature.\n\n---"
  }
]
<shellId: 5 completed with exit code 0>
```

</details>


---

<sub>1m 13s</sub>

### Copilot

All nine gating questions have substantive resolution blocks, and the plan contains exactly five direct implementation tasks. I’m persisting complete, serially ordered specifications with the resolved constraints and research findings embedded, then I’ll run the mandatory draft validator before any issue is created.

---

<sub>2m 28s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

````json
"*** Begin Patch\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-1021/issue-bodies/01-4.1-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including `### Domain acceptance behavior` and `### Hard scope constraints`.\n+- `### 3.2 — What is the exact domain mutation?` Resolution: add `BookingService.changeDeadline(TrackingId, Date)`; load the cargo, replace its `RouteSpecification` using the existing origin, existing destination, and supplied deadline, apply it through `Cargo.specifyNewRoute(...)`, and persist with `cargoRepository.store(...)`. Do not add mutable deadline setters.\n+- `### 3.3 — What should happen to an existing itinerary and delivery state?` Resolution: retain the itinerary and let `Cargo.specifyNewRoute(...)` recalculate delivery and routing state; in the established sequence the cargo remains `MISROUTED`.\n+- `### 3.8 — What date validation is required?` Resolution: require a non-null date but add no new rule requiring it to be after today, the old deadline, or itinerary legs; rely on existing `RouteSpecification` invariants.\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?` Resolution: append `testChangeDeadline()` after `testChangeDestination()` in the sequential Arquillian test. The Open Liberty build compiles this test but intentionally retains `skipTests=true`; running Arquillian still requires the documented remote Payara environment.\n+- `### 4.1 — Issue 1: Add the application-layer deadline change operation`.\n+- `## Cross-cutting concerns`, especially domain-driven design, layering, date handling, error handling, backward compatibility, test discipline, and experiment integrity.\n+\n+Research established that the historical Open Liberty package gate compiles test sources while skipping Arquillian execution by default. Do not modernize the test runtime or manufacture a passing execution result. Implement the production behavior and application test from scratch against production classes; do not copy or adapt spike code or feature-bearing commits.\n+\n+## Branch and execution order\n+\n+Target `experiment/shepherd-control` from remote `origin`. This is serial task 1 of 5. Tasks are assigned, completed, and merged in plan order; do not start work until this issue is assigned. Complete and gate this task before task 2 begins.\n+\n+Start from the campaign baseline and preserve Java 17 runtime compatibility, Java EE 7 `javax.*`, Java 7 source/target compatibility, Open Liberty 26.0.0.8, Derby, and the existing test configuration.\n+\n+## Implement\n+\n+Modify only:\n+\n+- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`\n+- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`\n+- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`\n+\n+Add this application API:\n+\n+```java\n+void changeDeadline(TrackingId trackingId, Date deadline);\n+```\n+\n+Implement it in `DefaultBookingService` by:\n+\n+1. Loading the aggregate with `cargoRepository.find(trackingId)`.\n+2. Reading the current destination from `cargo.getRouteSpecification().getDestination()`.\n+3. Constructing a replacement `RouteSpecification` from `cargo.getOrigin()`, the current destination, and the supplied deadline.\n+4. Calling `cargo.specifyNewRoute(routeSpecification)`.\n+5. Calling `cargoRepository.store(cargo)`.\n+6. Logging the tracking ID and new deadline at `Level.INFO` in the style of `changeDestination(...)`.\n+\n+Write the test first. Append sequential `testChangeDeadline()` after `testChangeDestination()`. Advance the original test deadline by one month, invoke the new service operation, reload with `Cargo.findByTrackingId`, and explicitly assert:\n+\n+- origin is still Chicago;\n+- destination is still Helsinki;\n+- stored deadline is the same calendar day as requested;\n+- the assigned itinerary is unchanged;\n+- transport status is `NOT_RECEIVED`;\n+- last known location is `Location.UNKNOWN`;\n+- current voyage is `Voyage.NONE`;\n+- the cargo is not misdirected;\n+- ETA is `Delivery.ETA_UNKOWN`;\n+- next expected activity is `Delivery.NO_ACTIVITY`;\n+- the cargo is not unloaded at destination;\n+- routing status is `MISROUTED`.\n+\n+Surface lookup, invalid-date/domain, and persistence failures normally; do not turn a failed mutation into success.\n+\n+## Completion gates\n+\n+- Test source compiles with the new sequential method in the specified position.\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- Existing application behavior and tests remain intact.\n+- The diff contains no web, facade, REST, Liberty, Derby, messaging, batch, or persistence-configuration changes.\n+- The mutation demonstrably preserves origin, destination, and itinerary while recalculating domain-derived state through the aggregate.\n+\n+## Out of scope\n+\n+- JSF, PrimeFaces, facade, dialog, dashboard, REST, runtime, and persistence configuration changes.\n+- A setter on `Cargo` or `RouteSpecification`, direct persistence-field mutation, itinerary clearing/replacement, or automatic rerouting.\n+- New chronological deadline policy.\n+- Arquillian/Payara modernization, changes to `skipTests`, or a new mocking dependency.\n+- Cherry-picking, copying, or inspecting feature-bearing commits or spike source.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-1021/issue-bodies/02-4.2-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including `### Domain acceptance behavior` and `### Hard scope constraints`.\n+- `### 3.1 — Which cargos expose the edit operation?` Resolution: only the Not Routed dashboard table will expose the UI affordance, but application and facade operations remain callable for any cargo found by tracking ID.\n+- `### 3.2 — What is the exact domain mutation?` Resolution: the already-merged application operation owns aggregate loading, `RouteSpecification` replacement, `Cargo.specifyNewRoute(...)`, and repository storage.\n+- `### 3.4 — What type crosses the facade boundary?` Resolution: add `void changeDeadline(String trackingId, Date arrivalDeadline)`; convert the string to `new TrackingId(trackingId)` and pass the same `Date` to the application service. Add no command DTO or formatted-string parameter.\n+- `### 3.8 — What date validation is required?` Resolution: the UI will require a non-null date, but no new chronological rule belongs in this facade.\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?` Resolution: container-free focused tests may use hand-written fakes; do not add a mocking dependency. The Open Liberty package build is the mandatory compilation gate.\n+- `### 4.2 — Issue 2: Expose deadline changes through the booking facade`.\n+- `## Cross-cutting concerns`, especially layering, date handling, error handling, backward compatibility, and experiment integrity.\n+\n+Research established that this historical application deliberately uses `java.util.Date` at the service/facade boundary and that adding a command DTO or formatted date would create needless conversion. It also established that the existing build compiles test sources while retaining `skipTests=true`. Implement from production contracts; do not copy or adapt spike code.\n+\n+## Branch and execution order\n+\n+Target `experiment/shepherd-control` from remote `origin`. This is serial task 2 of 5 and depends on task 1 being merged and gated. Tasks are assigned, completed, and merged in plan order; do not start work until this issue is assigned.\n+\n+Preserve Java EE 7 `javax.*`, Java 7 source/target compatibility, and the existing public facade behavior.\n+\n+## Implement\n+\n+Modify:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`\n+\n+Optionally add a focused container-free test at:\n+\n+- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`\n+\n+Add the facade API:\n+\n+```java\n+void changeDeadline(String trackingId, Date arrivalDeadline);\n+```\n+\n+Delegate exactly as follows:\n+\n+```java\n+bookingService.changeDeadline(\n+        new TrackingId(trackingId),\n+        arrivalDeadline);\n+```\n+\n+The facade converts only the identifier. It must pass the same deadline value/object through unchanged and must allow application/domain failures to propagate according to existing conventions.\n+\n+If a focused test is practical without a container, use a hand-written `BookingService` fake or spy and prove:\n+\n+- the string becomes an equivalent `TrackingId`;\n+- the same `Date` reaches `BookingService`;\n+- delegation occurs exactly once;\n+- the facade performs no repository or aggregate work.\n+\n+## Completion gates\n+\n+- Existing facade consumers compile unchanged.\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- Task 1's application-layer test remains unchanged and compiling.\n+- A focused test, if added, uses no new test dependency and discriminates identifier conversion, date preservation, and exactly-once delegation.\n+- The diff remains confined to the facade contract/implementation and an optional focused test.\n+\n+## Out of scope\n+\n+- Loading or mutating `Cargo`, constructing `RouteSpecification`, or calling `CargoRepository.store(...)` in the facade.\n+- Parsing or formatting the deadline, adding a command DTO, or exposing `TrackingId`, `Cargo`, or `RouteSpecification` to JSF.\n+- JSF/PrimeFaces beans, XHTML, dashboard integration, runtime configuration, or application-service redesign.\n+- New date policy, mocking libraries, Arquillian modernization, feature-bearing commits, or spike source.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-1021/issue-bodies/03-4.3-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including the user-visible acceptance behavior and hard scope constraints.\n+- `### 3.4 — What type crosses the facade boundary?` Resolution: the web layer passes a string tracking ID and `java.util.Date` through `BookingServiceFacade.changeDeadline(...)`; domain types do not cross into JSF.\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?` Resolution: conversion stays in the view-scoped bean. Load `CargoRoute`, create a per-load `SimpleDateFormat(\"MM/dd/yyyy\")`, and parse the leading date portion of `cargo.getArrivalDeadline()`, which starts with the same date displayed by `getArrivalDeadlineDate()`. Do not use a shared mutable formatter or silently return null on parse failure.\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?` Resolution: use a serializable CDI `@Named @ViewScoped` editor matching the existing Change Destination interaction.\n+- `### 3.8 — What date validation is required?` Resolution: reject null, but add no future/minimum/itinerary chronology rule.\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?` Resolution: focused container-free tests may use hand-written fakes without a new mocking dependency; Open Liberty packaging is the mandatory compilation gate.\n+- `### 4.3 — Issue 3: Implement the deadline editor backing model`.\n+- `## Cross-cutting concerns`, especially layering, date handling, time zones, error handling, bean lifecycle, accessibility, and test discipline.\n+\n+Research established that `CargoRoute` exposes formatted text rather than a `Date`: its full arrival-deadline string begins with `MM/dd/yyyy`, while the table displays the date-only representation. A per-load parser preserves the DTO contract and avoids mutable formatter sharing. Implement this finding from scratch without reading or adapting spike code.\n+\n+## Branch and execution order\n+\n+Target `experiment/shepherd-control` from remote `origin`. This is serial task 3 of 5 and depends on tasks 1 and 2 being merged and gated. Tasks are assigned, completed, and merged in plan order; do not start work until this issue is assigned.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`\n+\n+Use this bean shape:\n+\n+```java\n+@Named\n+@ViewScoped\n+public class ChangeArrivalDeadlineDate implements Serializable {\n+    private static final long serialVersionUID = 1L;\n+\n+    private String trackingId;\n+    private CargoRoute cargo;\n+    private Date arrivalDeadlineDate;\n+\n+    @Inject\n+    private BookingServiceFacade bookingServiceFacade;\n+}\n+```\n+\n+Provide:\n+\n+- `getTrackingId()` / `setTrackingId(String)`\n+- `getCargo()`\n+- `getArrivalDeadlineDate()` / `setArrivalDeadlineDate(Date)`\n+- `load()`\n+- `changeArrivalDeadline()`\n+\n+`load()` must call `bookingServiceFacade.loadCargoForRouting(trackingId)`, retain the returned `CargoRoute`, parse the leading date portion of `cargo.getArrivalDeadline()` with a newly created `SimpleDateFormat(\"MM/dd/yyyy\")`, and store the result. It must not query repositories or domain objects. Surface malformed DTO data as a clear application/view error consistent with neighboring JSF code; do not swallow, print, or convert the failure to null.\n+\n+`changeArrivalDeadline()` must reject a null selection through JSF validation or explicit bean validation, invoke `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`, and only after successful delegation call:\n+\n+```java\n+PrimeFaces.current().dialog().closeDynamic(\"DONE\");\n+```\n+\n+Do not close the dialog if delegation fails.\n+\n+Add a container-free JUnit test if practical with a hand-written fake facade. Discriminate:\n+\n+- correct tracking ID on load;\n+- conversion of an `MM/dd/yyyy` leading DTO date to an editable `Date`;\n+- selected date and tracking ID delegated on submit;\n+- malformed DTO date is surfaced;\n+- null selected date is rejected;\n+- failed facade submission does not execute success-close behavior where that interaction can be tested without a container.\n+\n+## Completion gates\n+\n+- The bean is serializable and uses the established CDI/JSF annotations.\n+- It references facade contracts and DTOs only, never domain model or repository classes.\n+- Parsing and submission failures are explicit and not success-shaped.\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- All earlier application/facade gates remain intact.\n+\n+## Out of scope\n+\n+- Dialog launcher, XHTML, dashboard command link, or navigation changes.\n+- Changes to `CargoRoute`, repository access, domain types in JSF, shared `SimpleDateFormat`, or new timezone policy.\n+- A future/minimum deadline rule, new mocking dependency, runtime modernization, feature-bearing commits, or spike source.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-1021/issue-bodies/04-4.4-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, especially user-visible acceptance behavior and hard scope constraints.\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?` Resolution: the already-merged editor loads `CargoRoute` and converts its leading `MM/dd/yyyy` date locally.\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?` Resolution: mirror Change Destination with a serializable CDI `@Named @ViewScoped` editor and a serializable `@ManagedBean(name = \"changeArrivalDeadlineDateDialog\") @SessionScoped` launcher; use a PrimeFaces dynamic dialog.\n+- `### 3.7 — What is the dynamic-dialog contract?` Resolution: open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with one `trackingId` parameter; modal/draggable `true`, resizable `false`, width `410`, height `280`; update closes with `\"DONE\"`, cancel with `\"\"`; caller handles `dialogReturn` and updates `tableNotRouted`; `<f:metadata>` is directly beneath root `<html>` before `<h:head>` and `<h:body>`.\n+- `### 3.8 — What date validation is required?` Resolution: require a non-null selection with ordinary Faces feedback and no new chronology rule.\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?` Resolution: JDK 17 Open Liberty package/start, direct HTTP checks, and browser acceptance are mandatory; do not modernize Arquillian.\n+- `### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog`.\n+- `## Cross-cutting concerns`, especially JSF compatibility, bean lifecycle, accessibility, error handling, backward compatibility, and experiment integrity.\n+\n+Research established that MyFaces requires view metadata at `UIViewRoot` scope: placing `<f:metadata>` in `<h:body>` causes parent-component/tag failures. It also established the existing destination dialog as the compatible lifecycle pattern. Apply these findings from scratch; do not inspect, copy, or adapt spike code.\n+\n+## Branch and execution order\n+\n+Target `experiment/shepherd-control` from remote `origin`. This is serial task 4 of 5 and depends on tasks 1 through 3 being merged and gated. Tasks are assigned, completed, and merged in plan order; do not start work until this issue is assigned.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`\n+- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`\n+\n+The serializable launcher must use:\n+\n+```java\n+@ManagedBean(name = \"changeArrivalDeadlineDateDialog\")\n+@SessionScoped\n+```\n+\n+Implement `showDialog(String trackingId)`, `handleReturn(SelectEvent event)`, and `cancel()`. `showDialog(...)` passes `trackingId` as a `Map<String, List<String>>` request parameter and opens `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with `modal=true`, `draggable=true`, `resizable=false`, `contentWidth=410`, and `contentHeight=280`. `cancel()` closes with `\"\"` and never calls the facade. Preserve the destination dialog's caller-refresh behavior in `handleReturn`.\n+\n+The XHTML title is:\n+\n+```xhtml\n+<title>Change Deadline</title>\n+```\n+\n+Place this metadata directly below root `<html>` and before `<h:head>`:\n+\n+```xhtml\n+<f:metadata>\n+    <f:viewParam name=\"trackingId\"\n+                 value=\"#{changeArrivalDeadlineDate.trackingId}\"/>\n+    <f:viewAction action=\"#{changeArrivalDeadlineDate.load}\"/>\n+</f:metadata>\n+```\n+\n+The form displays read-only `Origin:` / `changeArrivalDeadlineDate.cargo.originName` and `Destination:` / `changeArrivalDeadlineDate.cargo.finalDestinationName`; a labeled, required `Deadline:` `p:datePicker` bound to `changeArrivalDeadlineDate.arrivalDeadlineDate`; validation feedback; Cancel invoking `changeArrivalDeadlineDateDialog.cancel()`; and Update invoking `changeArrivalDeadlineDate.changeArrivalDeadline()`. A successful close must cause the Administration caller to reload or refresh consistently with destination editing.\n+\n+With Liberty running, directly request:\n+\n+`http://localhost:8080/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789`\n+\n+Verify HTTP 200, title, cargo context, initialized date, Cancel preservation, and Update persistence. Inspect runtime output for `TagException`, `Parent UIComponent`, `FacesException`, and server errors.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty liberty:run` succeeds on JDK 17.\n+- Direct dialog loading renders the correct origin, destination, and current date.\n+- Update changes the deadline and closes only on success; Cancel closes without a mutation.\n+- No metadata-placement, tag, Faces, or server error occurs.\n+- Existing destination editing still works.\n+- Liberty is stopped cleanly before completion.\n+\n+## Out of scope\n+\n+- Linking the dialog from `listNotRouted.xhtml`; that is task 5.\n+- Inline editing, full-page navigation, domain/repository access from the web layer, or changes to the established editor/facade contracts.\n+- Java EE/Jakarta migration, runtime/configuration changes, new date policy, Arquillian modernization, feature-bearing commits, or spike source.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-1021/issue-bodies/05-4.5-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including all user-visible acceptance behavior, domain acceptance behavior, and hard scope constraints.\n+- `### 3.1 — Which cargos expose the edit operation?` Resolution: expose deadline editing only in `src/main/webapp/admin/tables/listNotRouted.xhtml`; application/facade operations remain generally callable.\n+- `### 3.3 — What should happen to an existing itinerary and delivery state?` Resolution: service behavior preserves itinerary and lets the aggregate recalculate state; dashboard integration must not add lifecycle mutation logic.\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?` Resolution: use the completed PrimeFaces dynamic-dialog flow matching Change Destination.\n+- `### 3.7 — What is the dynamic-dialog contract?` Resolution: the launcher opens the completed dialog with `trackingId`; successful update closes with `\"DONE\"`, Cancel with `\"\"`; the command link handles `dialogReturn` and updates `tableNotRouted`.\n+- `### 3.8 — What date validation is required?` Resolution: require non-null only; do not add date chronology rules in the dashboard.\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?` Resolution: mandatory evidence is the JDK 17 Open Liberty build/start, HTTP checks, and complete `DEF789` browser flow. Arquillian remains skipped without its documented Payara environment.\n+- `### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard`.\n+- `## Phase 5 — Documentation and implementation handoff`.\n+- `## Cross-cutting concerns`, especially accessibility, backward compatibility, test discipline, and experiment integrity.\n+\n+Research established that the adjacent Destination column already provides the compatible PrimeFaces command-link, edit-icon, `dialogReturn`, and table-refresh structure. Reproduce that production pattern for deadline behavior without copying spike code. It also established that transient JMS activation-order warnings are acceptable only when all endpoints subsequently activate; metadata errors, deployment errors, recurring batch authorization failures, and feature-attributable FFDC are not acceptable.\n+\n+## Branch and execution order\n+\n+Target `experiment/shepherd-control` from remote `origin`. This is serial task 5 of 5 and depends on tasks 1 through 4 being merged and gated. Tasks are assigned, completed, and merged in plan order; do not start work until this issue is assigned.\n+\n+## Implement\n+\n+Modify:\n+\n+- `src/main/webapp/admin/tables/listNotRouted.xhtml`\n+\n+In the existing Deadline column, replace plain deadline text with a `p:commandLink` that:\n+\n+- calls `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;\n+- continues to display `cargoNotRouted.arrivalDeadlineDate`;\n+- uses the existing Font Awesome edit-icon style;\n+- has a stable component ID such as `arrivalDeadlineToUpdate`;\n+- listens for `dialogReturn`;\n+- invokes `changeArrivalDeadlineDateDialog.handleReturn`;\n+- updates `tableNotRouted`;\n+- provides the exact tooltip `Click to change cargo arrival deadline date.`\n+\n+Follow the adjacent Destination column's structure and styling. Preserve visible date text and accessible labeling. Do not alter destination editing, tracking-ID routing, or other dashboard tables.\n+\n+Perform the complete acceptance flow with stable sample cargo `DEF789`:\n+\n+1. Run `./mvnw clean package -Popenliberty liberty:run` on JDK 17.\n+2. Confirm the home page returns HTTP 200 and open Administration.\n+3. Record `DEF789`'s original deadline; confirm an edit icon and exact tooltip.\n+4. Open the dialog and verify origin/destination identify `DEF789` and the editor has the current deadline.\n+5. Select a visibly different date, Update, and verify close plus `tableNotRouted` refresh.\n+6. Verify the selected date in the table, reload the page, and verify persistence for the running in-memory application.\n+7. Reopen and verify initialization to the changed date.\n+8. Cancel and verify no additional change.\n+9. Verify Destination editing still opens and selecting `DEF789` for routing does not produce an error page.\n+\n+Capture the before/after dates and note that the in-memory value resets after rebuild/restart. Update `README.md` only if it already enumerates user-facing Administration capabilities; if so, add one concise sentence about changing an unrouted cargo's deadline.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds and the full running-app flow above passes.\n+- Runtime logs contain none of `<f:metadata> Parent UIComponent`, `TagException`, `VerifyError`, `FacesException`, `CWWKZ0002E`, `CWWKZ0003E`, recurring batch authorization failures, or new feature-attributable FFDC.\n+- If transient JMS activation-order warnings occur, all message endpoints subsequently activate.\n+- Existing destination editing, routing, tracking, REST, messaging, batch, startup, Derby, Liberty, and JSF compatibility remain intact.\n+- No Java EE namespace migration or unrelated configuration change occurs.\n+- Acceptance evidence records `DEF789`, before/after dates, exact JDK 17 run command, and in-memory reset behavior.\n+- Liberty is stopped cleanly.\n+\n+## Out of scope\n+\n+- Exposing deadline editing in routed, misrouted, claimed, progressed, details-page, or other Administration tables.\n+- Changes to application, domain, facade, backing-bean, launcher, dialog contracts, tracking routing, or destination editing except a tightly coupled defect that blocks this integration.\n+- New authorization/lifecycle/date rules, framework/runtime/database migration, Arquillian modernization, feature-bearing commits, or spike source.\n*** End Patch\n"
````

</details>

```
Added 5 file(s): C:\Users\edburns\workareas\dd-3061974-03-cargotracker-windows-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260910-1021\issue-bodies\01-4.1-body.md, C:\Users\edburns\workareas\dd-3061974-03-cargotracker-windows-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260910-1021\issue-bodies\02-4.2-body.md, C:\Users\edburns\workareas\dd-3061974-03-cargotracker-windows-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260910-1021\issue-bodies\03-4.3-body.md, C:\Users\edburns\workareas\dd-3061974-03-cargotracker-windows-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260910-1021\issue-bodies\04-4.4-body.md, C:\Users\edburns\workareas\dd-3061974-03-cargotracker-windows-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260910-1021\issue-bodies\05-4.5-body.md
```


---

<sub>2m 38s</sub>

### `powershell`

**Validate persisted issue drafts**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'; $logDir='C:\\Users\\edburns\\workareas\\dd-3061974-03-cargotracker-windows-shepherd-control\\1-arrival-deadline-control-remove-before-merge\\prompts\\shepherd-task-20-20260910-1021'; $validator='C:\\Users\\edburns\\.copilot\\plugins\\shepherd-task\\scripts\\validate-stage20-drafts.ps1'; $files=@(& $validator -BodyDirectory (Join-Path $logDir 'issue-bodies') -ExpectedCount 5 -LessonPropagation 'off'); if($files.Count -ne 5){throw \"Validator returned $($files.Count) files.\"}; $files | ForEach-Object { [pscustomobject]@{Name=$_.Name;Lines=[IO.File]::ReadAllLines($_.FullName).Count;Bytes=$_.Length;Sha256=(Get-FileHash -Algorithm SHA256 -LiteralPath $_.FullName).Hash.ToLowerInvariant()} } | ConvertTo-Json",
  "description": "Validate persisted issue drafts",
  "initial_wait": 60,
  "mode": "sync"
}
```

</details>

<details>
<summary>33 lines</summary>

```
[
  {
    "Name": "01-4.1-body.md",
    "Lines": 77,
    "Bytes": 5627,
    "Sha256": "2cfc212b8d799e36e1330b8f326e228f98b84980a2d1c1aeceb25ae660b163fc"
  },
  {
    "Name": "02-4.2-body.md",
    "Lines": 71,
    "Bytes": 4792,
    "Sha256": "a83496a6977988e6d729eff582adfd4eb4f0b1a27320c5bb36b721b7c54bb441"
  },
  {
    "Name": "03-4.3-body.md",
    "Lines": 84,
    "Bytes": 5304,
    "Sha256": "cbc1641bd15c020e895ff2d7c7889883bec10074761535d220dd5fffe4dfd3ba"
  },
  {
    "Name": "04-4.4-body.md",
    "Lines": 75,
    "Bytes": 5563,
    "Sha256": "acd32b95d811511333d2ef44791df35eb1ec16f64cb854109e218f11b663cd53"
  },
  {
    "Name": "05-4.5-body.md",
    "Lines": 71,
    "Bytes": 6172,
    "Sha256": "c9ff88a6970ed60e3cdce72ce6f4ab2ded0d015e62dac02ad2f5ead99659b5af"
  }
]
<shellId: 6 completed with exit code 0>
```

</details>


---

<sub>2m 38s</sub>

### `sql`

**Advance drafting phase**

<details>
<summary>Arguments</summary>

```json
{
  "description": "Advance drafting phase",
  "query": "UPDATE todos SET status='done', updated_at=CURRENT_TIMESTAMP WHERE id='validate-stage20'; UPDATE todos SET status='in_progress', updated_at=CURRENT_TIMESTAMP WHERE id='draft-stage20'"
}
```

</details>

<details>
<summary>5 lines</summary>

```
Executed 2 statement(s):

1. UPDATE
   1 row(s) updated.

2. UPDATE
   1 row(s) updated.
```

</details>


---

<sub>2m 53s</sub>

### Copilot

The five persisted drafts passed the required validator with physical multi-line Markdown and all mandatory sections. GitHub mutation now begins as a one-shot serial operation: each issue will be ledgered immediately, REST-body verified, then linked before the next issue is created.

---

<sub>3m 19s</sub>

### `powershell`

**Create, verify, and link ordered issues**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'\n$repo='edburns/dd-3061974-03-cargotracker-windows'\n$parent=1\n$logDir='C:\\Users\\edburns\\workareas\\dd-3061974-03-cargotracker-windows-shepherd-control\\1-arrival-deadline-control-remove-before-merge\\prompts\\shepherd-task-20-20260910-1021'\n$verifier='C:\\Users\\edburns\\.copilot\\plugins\\shepherd-task\\scripts\\verify-github-issue-body.ps1'\n$ledgerPath=Join-Path $logDir 'creation-ledger.json'\n$resultPath=Join-Path $logDir 'stage-20-result.json'\n$tasks=@(\n  [pscustomobject]@{subsection='4.1 — Issue 1'; title='4.1 — Add the application-layer deadline change operation'; body='issue-bodies\\01-4.1-body.md'},\n  [pscustomobject]@{subsection='4.2 — Issue 2'; title='4.2 — Expose deadline changes through the booking facade'; body='issue-bodies\\02-4.2-body.md'},\n  [pscustomobject]@{subsection='4.3 — Issue 3'; title='4.3 — Implement the deadline editor backing model'; body='issue-bodies\\03-4.3-body.md'},\n  [pscustomobject]@{subsection='4.4 — Issue 4'; title='4.4 — Implement the PrimeFaces deadline dialog'; body='issue-bodies\\04-4.4-body.md'},\n  [pscustomobject]@{subsection='4.5 — Issue 5'; title='4.5 — Integrate deadline editing into the Administration dashboard'; body='issue-bodies\\05-4.5-body.md'}\n)\nfunction Write-AtomicText([string]$Path,[string]$Text){\n  $temp=\"$Path.tmp-$PID-$([guid]::NewGuid().ToString('N'))\"\n  try { [IO.File]::WriteAllText($temp,$Text,[Text.UTF8Encoding]::new($false)); [IO.File]::Move($temp,$Path,$true) }\n  finally { if(Test-Path -LiteralPath $temp){Remove-Item -LiteralPath $temp} }\n}\nfunction Write-Ledger([object[]]$Ledger){ $json=ConvertTo-Json -InputObject ([object[]]$Ledger) -Depth 10; Write-AtomicText $ledgerPath $json }\nfunction Read-CreationLedger {\n  $parsed=[IO.File]::ReadAllText($ledgerPath)|ConvertFrom-Json -NoEnumerate\n  if($parsed -isnot [System.Array]){throw 'Creation ledger JSON root must be an array.'}\n  $ledger=[object[]]$parsed\n  if(@($ledger|Where-Object{$_ -is [System.Array]}).Count -ne 0){throw 'Creation ledger must not contain nested array entries.'}\n  return $ledger\n}\nfunction Write-Result([string]$Status,$OperationError){\n  $obj=[ordered]@{schemaVersion=1;status=$Status;ledgerFile='creation-ledger.json';operationError=$OperationError}\n  Write-AtomicText $resultPath ($obj|ConvertTo-Json -Depth 6)\n}\nfunction Get-NormalizedChildren {\n  $output=& gh api \"repos/$repo/issues/$parent/sub_issues\" --paginate --slurp 2>&1\n  $exitCode=$LASTEXITCODE\n  if($exitCode -ne 0){throw \"Unable to query parent children: $($output|Out-String)\"}\n  $normalized=($output|Out-String)|jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end'\n  $jqExit=$LASTEXITCODE\n  if($jqExit -ne 0){throw \"Unable to normalize parent children: $($normalized|Out-String)\"}\n  return @(($normalized|Out-String)|ConvertFrom-Json)\n}\n$failedOperation='initialization'\ntry {\n  if(Test-Path -LiteralPath $ledgerPath -or Test-Path -LiteralPath $resultPath){throw 'Stage artifacts already exist; refusing to treat this one-shot operation as resumable.'}\n  $baseline=@(Get-NormalizedChildren)\n  Write-Ledger @()\n  Write-Result 'in_progress' $null\n  foreach($task in $tasks){\n    $bodyFile=Join-Path $logDir $task.body\n    $failedOperation=\"create $($task.subsection)\"\n    $createOutput=& gh api \"repos/$repo/issues\" -X POST -f \"title=$($task.title)\" -F \"body=@$bodyFile\" 2>&1\n    $createExit=$LASTEXITCODE\n    if($createExit -ne 0){throw \"Issue creation failed: $($createOutput|Out-String)\"}\n    try{$created=($createOutput|Out-String)|ConvertFrom-Json}catch{throw \"Issue creation returned invalid JSON: $($_.Exception.Message)\"}\n    foreach($field in 'id','number','node_id','html_url','title'){if($null -eq $created.$field){throw \"Issue creation response omitted $field.\"}}\n    $ledger=@(Read-CreationLedger)\n    $ledger+= [pscustomobject][ordered]@{implementationSubsection=$task.subsection;bodyFile=$task.body;id=[long]$created.id;number=[int]$created.number;title=[string]$created.title;url=[string]$created.html_url;body_verified=$false;linked=$false}\n    Write-Ledger $ledger\n\n    $failedOperation=\"body verification for issue #$($created.number)\"\n    $verifiedIssue=& $verifier -Repository $repo -IssueNumber ([int]$created.number) -ExpectedBodyPath $bodyFile -MaxAttempts 6 -DelaySeconds 5 -DiagnosticPath (Join-Path $logDir \"issue-$($created.number)-body-verification-failure.json\")\n    $ledger=@(Read-CreationLedger); $entry=$ledger|Where-Object number -eq ([int]$created.number)\n    if(@($entry).Count -ne 1){throw 'Ledger entry missing or duplicated after body verification.'}\n    $entry.body_verified=$true; Write-Ledger $ledger\n\n    $failedOperation=\"link issue #$($created.number) to parent #$parent\"\n    $linked=$false; $lastLinkError=''\n    for($attempt=1;$attempt -le 3 -and -not $linked;$attempt++){\n      $payload=\"{`\"sub_issue_id`\": $([long]$created.id)}\"\n      $linkOutput=$payload | & gh api \"repos/$repo/issues/$parent/sub_issues\" -X POST --input - 2>&1\n      $linkExit=$LASTEXITCODE\n      if($linkExit -eq 0){$linked=$true}else{$lastLinkError=($linkOutput|Out-String).Trim(); if($attempt -lt 3){Start-Sleep -Seconds 2}}\n    }\n    if(-not $linked){throw \"Linking failed after 3 attempts: $lastLinkError\"}\n    $ledger=@(Read-CreationLedger); $entry=$ledger|Where-Object number -eq ([int]$created.number); $entry.linked=$true; Write-Ledger $ledger\n  }\n\n  $failedOperation='final postcondition verification'\n  $ledger=@(Read-CreationLedger)\n  if($ledger.Count -ne 5){throw \"Expected 5 ledger entries; found $($ledger.Count).\"}\n  $finalChildren=@(Get-NormalizedChildren)\n  if($finalChildren.Count -ne ($baseline.Count+$ledger.Count)){throw \"Child count did not increase by 5: baseline=$($baseline.Count), final=$($finalChildren.Count).\"}\n  $newChildren=@($finalChildren|Where-Object{$baseline.id -notcontains $_.id})\n  if($newChildren.Count -ne $ledger.Count){throw 'New-child set does not match ledger size.'}\n  for($i=0;$i -lt $ledger.Count;$i++){\n    $entry=$ledger[$i]\n    $matches=@($finalChildren|Where-Object id -eq ([long]$entry.id))\n    if($matches.Count -ne 1){throw \"Issue #$($entry.number) is not linked exactly once.\"}\n    if([long]$newChildren[$i].id -ne [long]$entry.id){throw \"New child order differs at position $($i+1).\"}\n    if(-not $entry.body_verified -or -not $entry.linked){throw \"Ledger flags incomplete for issue #$($entry.number).\"}\n    $bodyFile=Join-Path $logDir $entry.bodyFile\n    $issue=& $verifier -Repository $repo -IssueNumber ([int]$entry.number) -ExpectedBodyPath $bodyFile -MaxAttempts 6 -DelaySeconds 5 -DiagnosticPath (Join-Path $logDir \"issue-$($entry.number)-body-verification-failure.json\")\n    if($issue.state -ne 'open'){throw \"Issue #$($entry.number) is not open.\"}\n    if(@($issue.assignees).Count -ne 0){throw \"Issue #$($entry.number) has assignees.\"}\n    if($issue.title -cne $entry.title){throw \"Issue #$($entry.number) title differs from ledger.\"}\n  }\n  Write-Result 'complete' $null\n  [pscustomobject]@{status='complete';issueType=$null;baselineCount=$baseline.Count;finalCount=$finalChildren.Count;ledger=$ledger}|ConvertTo-Json -Depth 8\n}\ncatch {\n  $operationError=\"$failedOperation`: $($_.Exception.Message)\"\n  if(Test-Path -LiteralPath $ledgerPath){\n    try{\n      $ledger=@(Read-CreationLedger)\n      $serverChildren=@(Get-NormalizedChildren)\n      foreach($entry in $ledger){$entry.linked=@($serverChildren|Where-Object id -eq ([long]$entry.id)).Count -eq 1}\n      Write-Ledger $ledger\n    }catch{$operationError+=\"; reconciliation error: $($_.Exception.Message)\"}\n  }else{$ledger=@()}\n  try{Write-Result 'failed' $operationError}catch{}\n  [Console]::Error.WriteLine($operationError)\n  [Console]::Error.WriteLine((ConvertTo-Json -InputObject ([object[]]$ledger) -Depth 8))\n  foreach($entry in $ledger){[Console]::Error.WriteLine(\"gh issue delete $($entry.number) --repo `\"$repo`\" --yes\")}\n  exit 1\n}",
  "description": "Create, verify, and link ordered issues",
  "initial_wait": 180,
  "mode": "sync"
}
```

</details>

```
initialization: Cannot bind parameter because parameter 'LiteralPath' is specified more than once. To provide multiple values to parameters that can accept multiple values, use the array syntax. For example, "-parameter value1,value2,value3".
[]
<shellId: 7 completed with exit code 1>
```


---

<sub>3m 31s</sub>

### Copilot

No GitHub issue was created: the operation stopped during local artifact initialization because of a PowerShell condition-parsing error, before the baseline query or first mutation. I’m correcting that pre-mutation script defect and restarting the still-empty creation operation; the failed status artifact will be atomically replaced while the empty GitHub baseline remains unchanged.

---

<sub>4m 5s</sub>

### `powershell`

**Create and verify ordered child issues**

<details>
<summary>Arguments</summary>

```json
{
  "command": "$ErrorActionPreference='Stop'\n$repo='edburns/dd-3061974-03-cargotracker-windows'; $parent=1\n$logDir='C:\\Users\\edburns\\workareas\\dd-3061974-03-cargotracker-windows-shepherd-control\\1-arrival-deadline-control-remove-before-merge\\prompts\\shepherd-task-20-20260910-1021'\n$verifier='C:\\Users\\edburns\\.copilot\\plugins\\shepherd-task\\scripts\\verify-github-issue-body.ps1'\n$ledgerPath=Join-Path $logDir 'creation-ledger.json'; $resultPath=Join-Path $logDir 'stage-20-result.json'\n$tasks=@(\n[pscustomobject]@{subsection='4.1 — Issue 1';title='4.1 — Add the application-layer deadline change operation';body='issue-bodies\\01-4.1-body.md'},\n[pscustomobject]@{subsection='4.2 — Issue 2';title='4.2 — Expose deadline changes through the booking facade';body='issue-bodies\\02-4.2-body.md'},\n[pscustomobject]@{subsection='4.3 — Issue 3';title='4.3 — Implement the deadline editor backing model';body='issue-bodies\\03-4.3-body.md'},\n[pscustomobject]@{subsection='4.4 — Issue 4';title='4.4 — Implement the PrimeFaces deadline dialog';body='issue-bodies\\04-4.4-body.md'},\n[pscustomobject]@{subsection='4.5 — Issue 5';title='4.5 — Integrate deadline editing into the Administration dashboard';body='issue-bodies\\05-4.5-body.md'})\nfunction Write-AtomicText([string]$Path,[string]$Text){$temp=\"$Path.tmp-$PID-$([guid]::NewGuid().ToString('N'))\";try{[IO.File]::WriteAllText($temp,$Text,[Text.UTF8Encoding]::new($false));[IO.File]::Move($temp,$Path,$true)}finally{if(Test-Path -LiteralPath $temp){Remove-Item -LiteralPath $temp}}}\nfunction Write-Ledger([object[]]$Ledger){Write-AtomicText $ledgerPath (ConvertTo-Json -InputObject ([object[]]$Ledger) -Depth 10)}\nfunction Read-CreationLedger{$parsed=[IO.File]::ReadAllText($ledgerPath)|ConvertFrom-Json -NoEnumerate;if($parsed -isnot [System.Array]){throw 'Creation ledger JSON root must be an array.'};$ledger=[object[]]$parsed;if(@($ledger|Where-Object{$_ -is [System.Array]}).Count -ne 0){throw 'Creation ledger must not contain nested array entries.'};return $ledger}\nfunction Write-Result([string]$Status,$OperationError){Write-AtomicText $resultPath ([ordered]@{schemaVersion=1;status=$Status;ledgerFile='creation-ledger.json';operationError=$OperationError}|ConvertTo-Json -Depth 6)}\nfunction Get-NormalizedChildren{$output=& gh api \"repos/$repo/issues/$parent/sub_issues\" --paginate --slurp 2>&1;$exitCode=$LASTEXITCODE;if($exitCode -ne 0){throw \"Unable to query parent children: $($output|Out-String)\"};$normalized=($output|Out-String)|jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end';$jqExit=$LASTEXITCODE;if($jqExit -ne 0){throw \"Unable to normalize parent children: $($normalized|Out-String)\"};return @(($normalized|Out-String)|ConvertFrom-Json)}\n$failedOperation='initialization'\ntry{\n if(Test-Path -LiteralPath $ledgerPath){throw 'Creation ledger already exists; refusing to resume.'}\n if(Test-Path -LiteralPath $resultPath){$prior=[IO.File]::ReadAllText($resultPath)|ConvertFrom-Json;if($prior.status -ne 'failed' -or $prior.operationError -notlike 'initialization:*'){throw 'Unexpected existing stage result; refusing to resume.'}}\n $baseline=@(Get-NormalizedChildren); if($baseline.Count -ne 0){throw \"Pre-creation baseline changed and now has $($baseline.Count) children.\"}\n Write-Ledger @(); Write-Result 'in_progress' $null\n foreach($task in $tasks){\n  $bodyFile=Join-Path $logDir $task.body; $failedOperation=\"create $($task.subsection)\"\n  $createOutput=& gh api \"repos/$repo/issues\" -X POST -f \"title=$($task.title)\" -F \"body=@$bodyFile\" 2>&1; $createExit=$LASTEXITCODE\n  if($createExit -ne 0){throw \"Issue creation failed: $($createOutput|Out-String)\"};try{$created=($createOutput|Out-String)|ConvertFrom-Json}catch{throw \"Issue creation returned invalid JSON: $($_.Exception.Message)\"}\n  foreach($field in 'id','number','node_id','html_url','title'){if($null -eq $created.$field){throw \"Issue creation response omitted $field.\"}}\n  $ledger=@(Read-CreationLedger);$ledger+=[pscustomobject][ordered]@{implementationSubsection=$task.subsection;bodyFile=$task.body;id=[long]$created.id;number=[int]$created.number;title=[string]$created.title;url=[string]$created.html_url;body_verified=$false;linked=$false};Write-Ledger $ledger\n  $failedOperation=\"body verification for issue #$($created.number)\";$verifiedIssue=& $verifier -Repository $repo -IssueNumber ([int]$created.number) -ExpectedBodyPath $bodyFile -MaxAttempts 6 -DelaySeconds 5 -DiagnosticPath (Join-Path $logDir \"issue-$($created.number)-body-verification-failure.json\")\n  $ledger=@(Read-CreationLedger);$entry=@($ledger|Where-Object number -eq ([int]$created.number));if($entry.Count -ne 1){throw 'Ledger entry missing or duplicated after body verification.'};$entry[0].body_verified=$true;Write-Ledger $ledger\n  $failedOperation=\"link issue #$($created.number) to parent #$parent\";$linked=$false;$lastLinkError=''\n  for($attempt=1;$attempt -le 3 -and -not $linked;$attempt++){$payload=\"{`\"sub_issue_id`\": $([long]$created.id)}\";$linkOutput=$payload|& gh api \"repos/$repo/issues/$parent/sub_issues\" -X POST --input - 2>&1;$linkExit=$LASTEXITCODE;if($linkExit -eq 0){$linked=$true}else{$lastLinkError=($linkOutput|Out-String).Trim();if($attempt -lt 3){Start-Sleep -Seconds 2}}}\n  if(-not $linked){throw \"Linking failed after 3 attempts: $lastLinkError\"};$ledger=@(Read-CreationLedger);$entry=@($ledger|Where-Object number -eq ([int]$created.number));$entry[0].linked=$true;Write-Ledger $ledger\n }\n $failedOperation='final postcondition verification';$ledger=@(Read-CreationLedger);if($ledger.Count -ne 5){throw \"Expected 5 ledger entries; found $($ledger.Count).\"}\n $finalChildren=@(Get-NormalizedChildren);if($finalChildren.Count -ne ($baseline.Count+$ledger.Count)){throw \"Child count mismatch: baseline=$($baseline.Count), final=$($finalChildren.Count).\"}\n $newChildren=@($finalChildren|Where-Object{$baseline.id -notcontains $_.id});if($newChildren.Count -ne $ledger.Count){throw 'New-child set does not match ledger size.'}\n for($i=0;$i -lt $ledger.Count;$i++){$entry=$ledger[$i];$matches=@($finalChildren|Where-Object id -eq ([long]$entry.id));if($matches.Count -ne 1){throw \"Issue #$($entry.number) is not linked exactly once.\"};if([long]$newChildren[$i].id -ne [long]$entry.id){throw \"New child order differs at position $($i+1).\"};if(-not $entry.body_verified -or -not $entry.linked){throw \"Ledger flags incomplete for issue #$($entry.number).\"};$issue=& $verifier -Repository $repo -IssueNumber ([int]$entry.number) -ExpectedBodyPath (Join-Path $logDir $entry.bodyFile) -MaxAttempts 6 -DelaySeconds 5 -DiagnosticPath (Join-Path $logDir \"issue-$($entry.number)-body-verification-failure.json\");if($issue.state -ne 'open'){throw \"Issue #$($entry.number) is not open.\"};if(@($issue.assignees).Count -ne 0){throw \"Issue #$($entry.number) has assignees.\"};if($issue.title -cne $entry.title){throw \"Issue #$($entry.number) title differs from ledger.\"}}\n Write-Result 'complete' $null;[pscustomobject]@{status='complete';issueType=$null;baselineCount=$baseline.Count;finalCount=$finalChildren.Count;ledger=$ledger}|ConvertTo-Json -Depth 8\n}catch{$operationError=\"$failedOperation`: $($_.Exception.Message)\";if(Test-Path -LiteralPath $ledgerPath){try{$ledger=@(Read-CreationLedger);$serverChildren=@(Get-NormalizedChildren);foreach($entry in $ledger){$entry.linked=@($serverChildren|Where-Object id -eq ([long]$entry.id)).Count -eq 1};Write-Ledger $ledger}catch{$operationError+=\"; reconciliation error: $($_.Exception.Message)\"}}else{$ledger=@()};try{Write-Result 'failed' $operationError}catch{};[Console]::Error.WriteLine($operationError);[Console]::Error.WriteLine((ConvertTo-Json -InputObject ([object[]]$ledger) -Depth 8));foreach($entry in $ledger){[Console]::Error.WriteLine(\"gh issue delete $($entry.number) --repo `\"$repo`\" --yes\")};exit 1}",
  "description": "Create and verify ordered child issues",
  "initial_wait": 180,
  "mode": "sync"
}
```

</details>

<details>
<summary>59 lines</summary>

```
{
  "status": "complete",
  "issueType": null,
  "baselineCount": 0,
  "finalCount": 5,
  "ledger": [
    {
      "implementationSubsection": "4.1 — Issue 1",
      "bodyFile": "issue-bodies\\01-4.1-body.md",
      "id": 5415310171,
      "number": 2,
      "title": "4.1 — Add the application-layer deadline change operation",
      "url": "https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/2",
      "body_verified": true,
      "linked": true
    },
    {
      "implementationSubsection": "4.2 — Issue 2",
      "bodyFile": "issue-bodies\\02-4.2-body.md",
      "id": 5415310465,
      "number": 3,
      "title": "4.2 — Expose deadline changes through the booking facade",
      "url": "https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/3",
      "body_verified": true,
      "linked": true
    },
    {
      "implementationSubsection": "4.3 — Issue 3",
      "bodyFile": "issue-bodies\\03-4.3-body.md",
      "id": 5415310698,
      "number": 4,
      "title": "4.3 — Implement the deadline editor backing model",
      "url": "https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/4",
      "body_verified": true,
      "linked": true
    },
    {
      "implementationSubsection": "4.4 — Issue 4",
      "bodyFile": "issue-bodies\\04-4.4-body.md",
      "id": 5415310995,
      "number": 5,
      "title": "4.4 — Implement the PrimeFaces deadline dialog",
      "url": "https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/5",
      "body_verified": true,
      "linked": true
    },
    {
      "implementationSubsection": "4.5 — Issue 5",
      "bodyFile": "issue-bodies\\05-4.5-body.md",
      "id": 5415311287,
      "number": 6,
      "title": "4.5 — Integrate deadline editing into the Administration dashboard",
      "url": "https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/6",
      "body_verified": true,
      "linked": true
    }
  ]
}
<shellId: 8 completed with exit code 0>
```

</details>


---

<sub>4m 9s</sub>

### Copilot

All five issues were created, body-verified twice, linked once in plan order, left open and unassigned, and the authoritative stage result is `complete`. I’m finalizing the handoff metadata and confirming the exact stage-25 invocation form.

---

<sub>4m 17s</sub>

### `rg`

**shepherd-task-25-given-list**

"shepherd-task-25-given-list" in *.{md,json,ps1,sh} (~\.copilot\plugins\shepherd-task)

<details>
<summary>91 matches</summary>

```
[grep content: 76 matches across 47 file(s) under C:/Users/edburns/.copilot/plugins/shepherd-task]

figure (2 match(es)):
  01- shepherd-task-25-given-list.md:3:Stage 25 (`shepherd-task-25-given-list`) owns one serial run. It validates the durable campaign
  01- shepherd-task-25-given-list.md:11:    participant GL as Stage 25: shepherd-task-25-given-list

README.md (8 match(es)):
  33: - one or more `shepherd-task-25-given-list` runs.
  54: | 25         |                                                    | `shepherd-task-25-given-list`                     | Runs selected child issues serially, invokes `shepherd-task` separately for each issue to perform stages 30 and 40, and always invokes stage 50 |
  254: ./plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh \
  262: .\plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1 `
  293: - [Figure 01 — stage 25 given-list batch orchestration](figure-01-shepherd-task-25-given-list.md)
  441: `shepherd-task-25-given-list-run.json`:
  531:     ├── shepherd-task-25-given-list-run.json
  611: | `scripts/shepherd-task-25-given-list.*` | Run stage 25: create a run and dispatch issues serially |

test/lesson-propagation-default-contract.ps1 (4 match(es)):
  9: $stage25 = Join-Path $scriptsDirectory 'shepherd-task-25-given-list.ps1'
  160:         (Join-Path $harnessDirectory 'shepherd-task-25-given-list.ps1'),
  196:             Join-Path $harnessDirectory 'shepherd-task-25-given-list.ps1'
  214:         Join-Path $runDirectories[0].FullName 'shepherd-task-25-given-list-run.json'

skills/shepherd-task (3 match(es)):
  20- create-issues-from-plan\SKILL.md:306:2. Comma-separated child issue numbers for `shepherd-task-25-given-list`.
  50- create-post-mortem\SKILL.md:13:This skill is designed to be invoked from `shepherd-task-25-given-list.ps1` / `shepherd-task-25-given-list.sh` in a `finally` / `trap EXIT` path so it runs for **all outcomes**, not only after success.
  50- create-post-mortem\SKILL.md:60:2. If `shepherd-task-25-given-list-run.json` exists, verify its campaign ID,
test/cargotracker-add-change-arrival-deadline-feature/06-stage40-review-contract.sh:9: STAGE25="$REPO_ROOT/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh"
test/cargotracker-add-change-arrival-deadline-feature/06-stage40-review-contract.ps1:14: $stage25Path = Join-Path $repoRoot 'plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1'
test/cargotracker-add-change-arrival-deadline-feature/10-cargotracker-fixture-contract.ps1:201:     "scripts\\shepherd-task-25-given-list\.ps1"
test/cargotracker-add-change-arrival-deadline-feature/08-psncpps-contract.sh:8: stage25="$scripts_directory/shepherd-task-25-given-list.sh"
test/cargotracker-add-change-arrival-deadline-feature/08-psncpps-contract.ps1:13: $stage25 = Join-Path $scriptsDirectory 'shepherd-task-25-given-list.ps1'
test/cargotracker-add-change-arrival-deadline-feature/02-create-issues.sh:221:     "$scripts_directory/shepherd-task-25-given-list.sh" \
test/cargotracker-add-change-arrival-deadline-feature/07-driver-encoding-contract.sh:52:     'shepherd-task-25-given-list.sh'
test/cargotracker-add-change-arrival-deadline-feature/02-create-issues.ps1:263:     (Join-Path $PSScriptRoot '..' '..' 'scripts' 'shepherd-task-25-given-list.ps1')
test/cargotracker-add-change-arrival-deadline-feature/07-driver-encoding-contract.ps1:296:         'shepherd-task-25-given-list.ps1',

test/cargotracker-add-change-arrival-deadline-feature/run-campaign.sh (2 match(es)):
  189:         local manifest="$directory/shepherd-task-25-given-list-run.json"
  336: stage25_script="$shepherd_plugin/scripts/shepherd-task-25-given-list.sh"
test/lesson-propagation-default-contract.sh:9: STAGE25="$SCRIPTS_DIR/shepherd-task-25-given-list.sh"

test/cargotracker-add-change-arrival-deadline-feature/run-campaign.ps1 (2 match(es)):
  341:                 $manifestPath = Join-Path $_.FullName 'shepherd-task-25-given-list-run.json'
  473:         'scripts\shepherd-task-25-given-list.ps1'
test/cargotracker-add-change-arrival-deadline-feature/10-cargotracker-fixture-contract.sh:136: [[ "$(grep -Fc 'shepherd-task-25-given-list.sh' "$driver")" -eq 1 ]] ||
test/cargotracker-add-change-arrival-deadline-feature-treatment-control/02-create-issues.ps1:254:     (Join-Path $PSScriptRoot '..' '..' 'scripts' 'shepherd-task-25-given-list.ps1')
test/version-lineup-contract.sh:64: grep -Fq 'stageOutcomeProtocolVersion:' "$plugin_root/scripts/shepherd-task-25-given-list.sh"
test/simple-math-treatment-control/02-create-issues.ps1:251:     (Join-Path $PSScriptRoot '..' '..' 'scripts' 'shepherd-task-25-given-list.ps1')

scripts/shepherd-task (5 match(es)):
  25- given-list.ps1:65:$runManifestPath = Join-Path $logDirFull 'shepherd-task-25-given-list-run.json'
  25- given-list.ps1:117:    Write-Host "Logging shepherd-task-25-given-list run to: $logDirFull"
  25- given-list.sh:6:#   ./shepherd-task-25-given-list.sh <TASK_ISSUES> <CAMPAIGN_METADATA_DIRECTORY>
  25- given-list.sh:80:RUN_MANIFEST="$LOG_DIR_FULL/shepherd-task-25-given-list-run.json"
  25- given-list.sh:116:echo "Logging shepherd-task-25-given-list run to: $LOG_DIR_FULL"
test/cargotracker-add-change-arrival-deadline-feature-treatment-control/06-stage40-review-contract.ps1:14: $stage25Path = Join-Path $repoRoot 'plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1'
test/cargotracker-add-change-arrival-deadline-feature-treatment-control/06-stage40-review-contract.sh:9: STAGE25="$REPO_ROOT/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh"
test/simple-math/02-create-issues.ps1:260:     (Join-Path $PSScriptRoot '..' '..' 'scripts' 'shepherd-task-25-given-list.ps1')
test/cargotracker-add-change-arrival-deadline-feature-treatment-control/08-psncpps-contract.ps1:13: $stage25 = Join-Path $scriptsDirectory 'shepherd-task-25-given-list.ps1'
test/simple-math-treatment-control/06-stage40-review-contract.ps1:14: $stage25Path = Join-Path $repoRoot 'plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1'
test/simple-math-treatment-control/06-stage40-review-contract.sh:9: STAGE25="$REPO_ROOT/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh"
test/simple-math/02-create-issues.sh:25: stage25="$scripts_directory/shepherd-task-25-given-list.sh"
scripts/shepherd-task-monitor.ps1:10:     Run this in a SEPARATE terminal while shepherd-task-25-given-list.ps1 is running.
scripts/shepherd-task-monitor.sh:9: # Run this in a SEPARATE terminal while shepherd-task-25-given-list.sh is running.
scripts/shepherd-task.ps1:22:     Existing shepherd-task-25-given-list run directory.
test/simple-math-treatment-control/08-psncpps-contract.ps1:13: $stage25 = Join-Path $scriptsDirectory 'shepherd-task-25-given-list.ps1'

test/simple-math-treatment-control/20260831-run-treatment-control-experiment.ps1 (3 match(es)):
  150:                 $manifestPath = Join-Path $_.FullName 'shepherd-task-25-given-list-run.json'
  496:         -Path (Join-Path $ShepherdPlugin 'scripts\shepherd-task-25-given-list.ps1') `
  506:         -Path (Join-Path $ShepherdPlugin 'scripts\shepherd-task-25-given-list.ps1') `
test/simple-math/06-stage40-review-contract.ps1:14: $stage25Path = Join-Path $repoRoot 'plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1'
test/simple-math/06-stage40-review-contract.sh:9: STAGE25="$REPO_ROOT/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh"

test/cargotracker-add-change-arrival-deadline-feature-treatment-control/20260902-run-treatment-control-experiment.ps1 (3 match(es)):
  149:                 $manifestPath = Join-Path $_.FullName 'shepherd-task-25-given-list-run.json'
  502:         -Path (Join-Path $ShepherdPlugin 'scripts\shepherd-task-25-given-list.ps1') `
  512:         -Path (Join-Path $ShepherdPlugin 'scripts\shepherd-task-25-given-list.ps1') `

test/simple-math-treatment-control/README.md (2 match(es)):
  407: & "$ShepherdPlugin/scripts/shepherd-task-25-given-list.ps1" `
  416: & "$ShepherdPlugin/scripts/shepherd-task-25-given-list.ps1" `
test/simple-math/07-driver-encoding-contract.ps1:296:         'shepherd-task-25-given-list.ps1',

test/cargotracker-add-change-arrival-deadline-feature-treatment-control/202609023-1638Z-run-treatment-control-experiment-resumeable.ps1 (3 match(es)):
  180:             'shepherd-task-25-given-list-run.json'
  395:         'shepherd-task-25-given-list-run.json'
  436:                 'scripts\shepherd-task-25-given-list.ps1') `
test/simple-math/07-driver-encoding-contract.sh:46:     'shepherd-task-25-given-list.sh'
test/simple-math/08-psncpps-contract.ps1:13: $stage25 = Join-Path $scriptsDirectory 'shepherd-task-25-given-list.ps1'
test/simple-math/08-psncpps-contract.sh:17: stage25="$scripts_directory/shepherd-task-25-given-list.sh"
test/simple-math/10-simple-math-fixture-contract.ps1:112:     "scripts\\shepherd-task-25-given-list\.ps1"
test/simple-math/10-simple-math-fixture-contract.sh:77: [[ "$(grep -Fc 'scripts/shepherd-task-25-given-list.sh' "$driver")" -eq 1 ]] ||

test/cargotracker-add-change-arrival-deadline-feature-treatment-control/README.md (2 match(es)):
  305: & "$ShepherdPlugin\scripts\shepherd-task-25-given-list.ps1" `
  310: & "$ShepherdPlugin\scripts\shepherd-task-25-given-list.ps1" `

test/simple-math/run-campaign.ps1 (2 match(es)):
  339:                 $manifestPath = Join-Path $_.FullName 'shepherd-task-25-given-list-run.json'
  468:         'scripts\shepherd-task-25-given-list.ps1'

test/simple-math/run-campaign.sh (2 match(es)):
  201:         local manifest="$directory/shepherd-task-25-given-list-run.json"
  335:     local stage25_script="$shepherd_plugin/scripts/shepherd-task-25-given-list.sh"
```

</details>


---

<sub>4m 16s</sub>

### `view`

**view the file at C:\Users\edburns\workareas\dd-3061974-03-cargotracker-windows-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260910-1021\stage-20-result.json.**

C:\Users\edburns\workareas\dd-3061974-03-cargotracker-windows-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260910-1021\stage-20-result.json

<details>
<summary>6 lines</summary>

```
{
  "schemaVersion": 1,
  "status": "complete",
  "ledgerFile": "creation-ledger.json",
  "operationError": null
}
```

</details>


---

<sub>4m 15s</sub>

### `view`

**view the file at C:\Users\edburns\workareas\dd-3061974-03-cargotracker-windows-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260910-1021\creation-ledger.json.**

C:\Users\edburns\workareas\dd-3061974-03-cargotracker-windows-shepherd-control\1-arrival-deadline-control-remove-before-merge\prompts\shepherd-task-20-20260910-1021\creation-ledger.json

<details>
<summary>52 lines</summary>

```
[
  {
    "implementationSubsection": "4.1 — Issue 1",
    "bodyFile": "issue-bodies\\01-4.1-body.md",
    "id": 5415310171,
    "number": 2,
    "title": "4.1 — Add the application-layer deadline change operation",
    "url": "https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/2",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.2 — Issue 2",
    "bodyFile": "issue-bodies\\02-4.2-body.md",
    "id": 5415310465,
    "number": 3,
    "title": "4.2 — Expose deadline changes through the booking facade",
    "url": "https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/3",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.3 — Issue 3",
    "bodyFile": "issue-bodies\\03-4.3-body.md",
    "id": 5415310698,
    "number": 4,
    "title": "4.3 — Implement the deadline editor backing model",
    "url": "https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/4",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.4 — Issue 4",
    "bodyFile": "issue-bodies\\04-4.4-body.md",
    "id": 5415310995,
    "number": 5,
    "title": "4.4 — Implement the PrimeFaces deadline dialog",
    "url": "https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/5",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.5 — Issue 5",
    "bodyFile": "issue-bodies\\05-4.5-body.md",
    "id": 5415311287,
    "number": 6,
    "title": "4.5 — Integrate deadline editing into the Administration dashboard",
    "url": "https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/6",
    "body_verified": true,
    "linked": true
  }
]
```

</details>


---

<sub>4m 16s</sub>

### `sql`

**Complete stage twenty todos**

<details>
<summary>Arguments</summary>

```json
{
  "description": "Complete stage twenty todos",
  "query": "UPDATE todos SET status='done', updated_at=CURRENT_TIMESTAMP WHERE id IN ('draft-stage20','create-stage20','verify-stage20'); SELECT id,status FROM todos ORDER BY created_at,id"
}
```

</details>

<details>
<summary>11 lines</summary>

```
Executed 2 statement(s):

1. UPDATE
   3 row(s) updated.

2. SELECT
   4 row(s) returned:
   
   | id | status |
   | --- | --- |
   | create-stage20 | done |
   | draft-stage20 | done |
   | validate-stage20 | done |
   | verify-stage20 | done |
```

</details>


---

<sub>4m 24s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\plugins\shepherd-task\README.md.**

C:\Users\edburns\.copilot\plugins\shepherd-task\README.md (lines 246-270)

<details>
<summary>17 lines</summary>

````
`stage-20-result.json` to explicitly report `complete`; a zero Copilot process
exit alone is not treated as successful issue creation.

### 5. Run stage 25 with an ordered issue list

Bash:

```bash
./plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh \
  "<issue-number>,<issue-number>" \
  <campaign-metadata-directory>
```

PowerShell:

```powershell
.\plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1 `
  -TaskIssues "<issue-number>,<issue-number>" `
  -CampaignMetadataDirectory <campaign-metadata-directory>
```

Stage 25 invokes `shepherd-task` for each issue in order.

**Note:** Manually invoking `shepherd-task` is also supported entry-point.
````

</details>


---

<sub>4m 23s</sub>

### `view`

**view the file at C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1.**

C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1 (lines 1-40)

<details>
<summary>34 lines</summary>

```
# shepherd-task-version: 1.0.2
<#
.SYNOPSIS
    Stage 25: dispatches an ordered issue subset within an initialized shepherd-task campaign.
#>

[CmdletBinding()]
param(
    [Parameter(Mandatory, Position = 0)]
    [string]$TaskIssues,

    [Parameter(Mandatory, Position = 1)]
    [string]$CampaignMetadataDirectory
)

Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'

$versionInfo = & (Join-Path $PSScriptRoot 'read-shepherd-task-version.ps1')

if ($TaskIssues -notmatch '^[1-9][0-9]*(,[1-9][0-9]*)*$') {
    throw 'TaskIssues must be a comma-separated list of positive issue numbers.'
}
if ([IO.Path]::IsPathRooted($CampaignMetadataDirectory) -or $CampaignMetadataDirectory -ne (Split-Path -Leaf $CampaignMetadataDirectory)) {
    throw 'CampaignMetadataDirectory must be a repository-root-relative basename.'
}
if ($CampaignMetadataDirectory -notmatch '^[1-9][0-9]*-[a-z0-9][a-z0-9-]*-remove-before-merge$') {
    throw 'CampaignMetadataDirectory does not follow the campaign directory naming contract.'
}

$repoRootOutput = @(& git rev-parse --show-toplevel 2>$null)
$gitExitCode = $LASTEXITCODE
if ($gitExitCode -ne 0 -or $repoRootOutput.Count -eq 0) {
    throw 'Run inside the campaign Git worktree.'
}
$repoRoot = $repoRootOutput | Select-Object -First 1
$repoRoot = [IO.Path]::GetFullPath($repoRoot.Trim())
$campaignPath = [IO.Path]::GetFullPath((Join-Path $repoRoot $CampaignMetadataDirectory))
if (-not (Test-Path -LiteralPath $campaignPath -PathType Container)) { throw "Campaign metadata directory not found: $campaignPath" }
$campaignPath = (Resolve-Path -LiteralPath $campaignPath).Path
```

</details>


---

<sub>4m 29s</sub>

### Copilot

**Stage 20 complete.** Five open, unassigned child issues were created under #1 in plan order, without an issue type.

| Subsection | Issue | Title |
|---|---:|---|
| 4.1 | [#2](https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/2) | Add the application-layer deadline change operation |
| 4.2 | [#3](https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/3) | Expose deadline changes through the booking facade |
| 4.3 | [#4](https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/4) | Implement the deadline editor backing model |
| 4.4 | [#5](https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/5) | Implement the PrimeFaces deadline dialog |
| 4.5 | [#6](https://github.com/edburns/dd-3061974-03-cargotracker-windows/issues/6) | Integrate deadline editing into the Administration dashboard |

**Ordered issue list:** `2,3,4,5,6`

```powershell
& "C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1" `
  -TaskIssues "2,3,4,5,6" `
  -CampaignMetadataDirectory "1-arrival-deadline-control-remove-before-merge"
```

The authoritative `stage-20-result.json` is `complete`; the persisted creation ledger records all five issues as body-verified and linked.

---

<sub>Generated by [GitHub Copilot CLI](https://github.com/features/copilot/cli)</sub>
